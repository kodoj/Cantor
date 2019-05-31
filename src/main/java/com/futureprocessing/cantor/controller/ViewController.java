package com.futureprocessing.cantor.controller;


import com.futureprocessing.cantor.model.User;
import com.futureprocessing.cantor.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cantor/exchange")
@Controller
public class ViewController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public String getCantor(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = (User) customUserDetailsService.loadUserByUsername(currentUser.getUsername());
        model.addAttribute("currentUser", user);
        return "cantor";
    }
}
