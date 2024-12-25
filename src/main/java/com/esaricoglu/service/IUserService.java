package com.esaricoglu.service;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;

import java.util.List;

public interface IUserService {

    List<DtoUser> findAll();

    void deleteById(Long id);

    DtoUser update(Long id, DtoUserIU dtoUserIU);
}
