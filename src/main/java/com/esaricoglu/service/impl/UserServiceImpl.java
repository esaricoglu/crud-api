package com.esaricoglu.service.impl;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;
import com.esaricoglu.model.User;
import com.esaricoglu.repository.UserRepository;
import com.esaricoglu.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<DtoUser> findAll() {
        List<User> users = userRepository.findAll();
        List<DtoUser> dtoUsers = new ArrayList<>();
        for (User user : users) {
            DtoUser dtoUser = new DtoUser();
            BeanUtils.copyProperties(user, dtoUser);
            dtoUsers.add(dtoUser);
        }
        return dtoUsers;
    }

    @Override
    public void deleteById(Long id) {
        // Exception handling
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

    @Override
    public DtoUser update(Long id, DtoUserIU dtoUserIU) {
        User user = userRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(dtoUserIU, user);
        userRepository.save(user);

        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(user, dtoUser);
        return dtoUser;
    }
}
