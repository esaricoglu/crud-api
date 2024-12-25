package com.esaricoglu.controller.impl;

import com.esaricoglu.controller.IUserController;
import com.esaricoglu.dto.DtoUser;
import com.esaricoglu.dto.DtoUserIU;
import com.esaricoglu.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @Override
    @GetMapping
    public List<DtoUser> findAll() {
        return userService.findAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @Override
    @PutMapping("/{id}")
    public DtoUser update(@PathVariable Long id,@Valid @RequestBody DtoUserIU dtoUserIU) {
        return userService.update(id, dtoUserIU);
    }
}
