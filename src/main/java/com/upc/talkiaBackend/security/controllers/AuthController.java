package com.upc.talkiaBackend.security.controllers;

import com.upc.talkiaBackend.security.dtos.AuthRequestDTO;
import com.upc.talkiaBackend.security.dtos.AuthResponseDTO;
import com.upc.talkiaBackend.security.services.CustomUserDetailsService;
import com.upc.talkiaBackend.security.util.JwtUtil;
import com.upc.talkiaBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "${ip.frontend}")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> createAuthenticationToken(@RequestBody AuthRequestDTO authRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        String rol = userDetails.getAuthorities().toString();
        Integer userId = userService.getIdByUsername(authRequest.getUsername());
        Integer levelId = userService.getLevelIdByUsername(authRequest.getUsername());

        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setJwt(token);
        authResponseDTO.setRol(rol);
        authResponseDTO.setUserId(userId);
        authResponseDTO.setLevelId(levelId);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        return ResponseEntity.ok().headers(responseHeaders).body(authResponseDTO);
        //return ResponseEntity.ok().headers(responseHeaders).build();
        //return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}


