package gr.hua.dit.agrodisastersystem.controller;

import gr.hua.dit.agrodisastersystem.config.jwt.JwtUtils;
import gr.hua.dit.agrodisastersystem.payload.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="*")
public class LoginController  {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public LoginController (AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    /**
     * This method is responsible to take the login details the user gave, make sure the user exists and the details are up to date
     * and grand access to the user based in their role and details in the database.
     *
     * @param loginRequest This is an object with multiple variables and about the details the user gave during the login, like passcode and other
     * @return String - Jwt response with username, role, TIN and ID.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            System.out.println(loginRequest);
            Authentication authenticationRequest =
                    UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());
            Authentication authenticationResponse =
                    this.authenticationManager.authenticate(authenticationRequest);
            String jwtToken = jwtUtils.generateJwtToken(authenticationResponse);
            String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
            return ResponseEntity.ok(new JwtResponse(jwtToken, username));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }
    }

    public record LoginRequest(String username, String password) {
    }
}
