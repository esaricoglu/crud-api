package com.esaricoglu.controller;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.AuthRequest;

public interface IAuthController {

    DtoUser register(AuthRequest request);
}
