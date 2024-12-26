package com.esaricoglu.service;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.AuthRequest;
import com.esaricoglu.jwt.AuthResponse;

public interface IAuthService {

    DtoUser register(AuthRequest request);

    AuthResponse login(AuthRequest request);
}
