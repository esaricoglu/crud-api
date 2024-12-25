package com.esaricoglu.controller.impl;

import com.esaricoglu.controller.IAuthController;
import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.AuthRequest;
import com.esaricoglu.jwt.AuthResponse;
import com.esaricoglu.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements IAuthController {

    @Autowired
    private IAuthService authService;

    @Override
    @PostMapping("/register")
    public DtoUser register(@Valid @RequestBody AuthRequest request) {
        return authService.register(request);
    }

    @Override
    @PostMapping("/login")
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }
}
