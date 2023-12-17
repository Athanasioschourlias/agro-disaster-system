package gr.hua.dit.agrodisastersystem.controller;

import gr.hua.dit.agrodisastersystem.payload.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="*")
public class Authentication {

    /**
     * This method is responsible to take the login details the user gave, make sure the user exists and the details are up to date
     * and grand access to the user based in their role and details in the database.
     *
     * @param   loginRequest This is an object with multiple variables and about the details the user gave during the login, like passcode and other
     * @return          String - Jwt response with username, role, TIN and ID.
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok("tha ginei kai to auth kapote");

    }
}
