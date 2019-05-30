package com.futureprocessing.cantor.controller;


import com.futureprocessing.cantor.model.User;
import com.futureprocessing.cantor.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CantorController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/saveUser")
    public void saveUser(User user) {
        customUserDetailsService.saveUser(user);
    }

}