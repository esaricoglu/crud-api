package com.esaricoglu.service.impl;

import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;
import com.esaricoglu.exception.BaseException;
import com.esaricoglu.exception.ErrorMessage;
import com.esaricoglu.exception.MessageType;
import com.esaricoglu.model.User;
import com.esaricoglu.repository.UserRepository;
import com.esaricoglu.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.USER_NOT_FOUND,id.toString()));
        }
        userRepository.delete(optional.get());
    }

    @Override
    public DtoUser update(Long id, DtoUserIU dtoUserIU) {
        Optional<User> optional = userRepository.findById(id);

        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.USER_NOT_FOUND, id.toString()));
        }
        User user = optional.get();
        dtoUserIU.setPassword(bCryptPasswordEncoder.encode(dtoUserIU.getPassword()));
        BeanUtils.copyProperties(dtoUserIU, user);
        userRepository.save(user);

        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(user, dtoUser);
        return dtoUser;
    }
}
