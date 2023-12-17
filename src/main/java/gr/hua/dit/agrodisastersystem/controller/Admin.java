package gr.hua.dit.agrodisastersystem.controller;

import gr.hua.dit.agrodisastersystem.model.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class Admin {

    /**
     * This function is responsible to fetch and return
     *
     * @return      A list of type USER
     */
    @GetMapping("/users/get_all")
    public List<User> getAllUsers() {

        return new ArrayList<>();

    }

    /**
     * This method is used in order to create and save a new user to the database
     *
     * @param   newUser this marks a parameter our endpoint accepts and describes its use.
     * @param   auth    .
     * @return          returns the newly created user info.
     */
    @PostMapping(path = "/users/register")
    public ResponseEntity<User> saveUsers(@RequestBody User newUser, Authentication auth) {

        throw new IllegalStateException("Not yet ready to add new users");

    }

    /**
     * This method updates an existing user based on their tin number
     *
     * @param   UserTin The Tax identifiers number of the user
     * @param   newUser A json of type new user
     * @return          returns the updated user.
     */
    @PutMapping ("/users/modify/{user_tin}")
    public ResponseEntity<User> updateUserByTIN(@PathVariable("user_tin") String UserTin,@RequestBody User newUser) {

        throw new IllegalStateException("Not yet ready to modify users by ID");


    }

    /**
     * This method updates an existing user based on their ID number
     *
     * @param   UserId The number of the user in the database
     * @param   newUser A json of type new user
     * @return          returns the updated user.
     */
    @PutMapping ("/users/modify/{user_id}")
    public ResponseEntity<User> updateUserById(@PathVariable("user_id") String UserId,@RequestBody User newUser) {

        throw new IllegalStateException("Not yet ready to modify users by TIM");


    }

    /**
     * This method deletes a user from the database based on their TIN number
     *
     * @param   UserTin The number of the user in the database
     * @return          String - Message and status whether the user deleted successfully or something went wrong
     */
    @DeleteMapping ("/users/delete/{user_tin}")
    public ResponseEntity<String> deleteUserByTIM(@PathVariable("user_tin") String UserTin) {

        return new ResponseEntity<>("Can not delete users if there are not any to delete by TIN",HttpStatus.OK);
    }

    /**
     * This method deletes a user from the database based on their ID number
     *
     * @param   UserId The number of the user in the database
     * @return          String - Message and status whether the user deleted successfully or something went wrong
     */
    @DeleteMapping ("/users/delete/{user_id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("user_id") String UserId) {

        return new ResponseEntity<>("Can not delete users if there are not any to delete by ID",HttpStatus.OK);
    }







}
