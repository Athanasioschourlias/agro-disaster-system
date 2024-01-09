package gr.hua.dit.agrodisastersystem.controller;

import gr.hua.dit.agrodisastersystem.model.Role;
import gr.hua.dit.agrodisastersystem.model.User;
import gr.hua.dit.agrodisastersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class Admin {

    @Autowired
    private UserService UserService;
    /**
     * This function is responsible to fetch and return all the user, ONLY for authenticated users/admins
     *
     * @return  Response entity of a list of type USER
     */
    @GetMapping("/users/get_all")
    public ResponseEntity<List<User>> getAllUsers() {
        try{
            return new ResponseEntity<>(UserService.findAllUsers(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This method is used in order to create and save a new user to the database
     *
     * @param   newUser A User like object which will replace the old user
     * @param   auth    Authentication token for validation
     * @return          returns the status of the call and an appropriate message
     */
    @PostMapping(path = "/users/register")
    public ResponseEntity<String> saveUsers(@RequestBody User newUser) {
        // Extract role names from the Set<Role>
        Set<String> roleNames = newUser.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        String result = UserService.createUser(newUser, roleNames);

        if (result.equals("User created successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            // If the result is an error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }


    /**
     * This method updates an existing user based on their tin number
     *
     * @param   userTin The Tax identifiers number of the user
     * @param   newUser A json of type new user
     * @return          returns the updated user.
     */
    @PutMapping("/users/modify/{user_tin}")
    public ResponseEntity<?> updateUserByTin(@PathVariable("user_tin") String userTin, @RequestBody User newUser) {
        try {
            User existingUser = UserService.findUserByTin(userTin);
            if (existingUser == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            User updatedUser = UserService.saveUser(existingUser, newUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception and return an appropriate response
            return new ResponseEntity<>("Error updating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method deletes a user from the database based on their TIN number
     *
     * @param   userTin The number of the user in the database
     * @return          String - Message and status whether the user deleted successfully or something went wrong
     */
    @DeleteMapping("/users/delete/{user_tin}")
    public ResponseEntity<String> deleteUserByTin(@PathVariable("user_tin") String userTin) {
        try {
            User user = UserService.findUserByTin(userTin);
            if (user == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            UserService.deleteUser(user);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception and return an appropriate response
            return new ResponseEntity<>("Error deleting user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
