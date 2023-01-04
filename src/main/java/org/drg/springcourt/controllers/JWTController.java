package org.drg.springcourt.controllers;

import org.drg.springcourt.dtos.requests.UserRequestDto;
import org.drg.springcourt.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/jwt")
public class JWTController {


    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    @ResponseBody
    ResponseEntity<String> login(@Valid @RequestBody UserRequestDto userRequestDto) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization","Bearer ".concat(jwtService.login(userRequestDto)));
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Successful login");
    }


}
