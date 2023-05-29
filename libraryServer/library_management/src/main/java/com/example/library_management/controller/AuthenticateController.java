package com.example.library_management.controller;

import com.example.library_management.config.JwtUtils;
import com.example.library_management.models.JwtRequest;
import com.example.library_management.models.JwtResponse;
import com.example.library_management.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {

        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }
        catch(UsernameNotFoundException e) {
            e.printStackTrace();
            System.out.println("User not found " + e.getMessage());
        }

        // user is authenticated

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = this.jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }

    private void authenticate (String username,String password) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch(DisabledException e) {
            e.printStackTrace();
            System.out.println("User Disabled " + e.getMessage());
        }
        catch(BadCredentialsException e) {
            e.printStackTrace();
            System.out.println("Invalid Credentials " + e.getMessage());
        }


    }

}
