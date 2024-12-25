package com.esaricoglu.service;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.jwt.AuthRequest;

public interface IAuthService {

    DtoUser register(AuthRequest request);
}
