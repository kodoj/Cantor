package com.futureprocessing.cantor.controller;


import com.futureprocessing.cantor.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CantorController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

//    @PreAuthorize("hasRole('USER')")


}