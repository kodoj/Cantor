package com.futureprocessing.cantor.controller;

import com.futureprocessing.cantor.model.Wallet;
import com.futureprocessing.cantor.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CantorController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/cantor/saveUser")
    public void saveUser(@RequestBody Wallet wallet, @AuthenticationPrincipal UserDetails currentUser) {
        customUserDetailsService.updateUserWallet(wallet, currentUser);
    }

}