package com.esaricoglu.controller;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.AuthRequest;
import com.esaricoglu.jwt.AuthResponse;

public interface IAuthController {

    DtoUser register(AuthRequest request);

    AuthResponse login(AuthRequest request);
}
