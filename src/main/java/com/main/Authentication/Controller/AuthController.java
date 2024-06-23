package com.main.Authentication.Controller;

import com.main.Authentication.Service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Authentication.Entities.AuthRequestDto;
import com.main.Authentication.Service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    // To Login Customer with valid username and password
    @Autowired
    private AuthService authService;

    @Autowired
    CommonService commonService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> authRequest(@RequestBody AuthRequestDto authRequestDto) {
        authRequestDto.setPassword(commonService.encodeData(authRequestDto.getPassword()));
        var userRegistrationResponse = authService.authRequest(authRequestDto);
        return new ResponseEntity<>(userRegistrationResponse, HttpStatus.OK);
    }
}
