package com.futureprocessing.cantor.controller;

import javax.validation.Valid;

import com.futureprocessing.cantor.model.User;
import com.futureprocessing.cantor.model.UserRegistrationDto;
import com.futureprocessing.cantor.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/registration")
@Controller
public class RegistrationController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "register.html";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {

        try {
            UserDetails existing = customUserDetailsService.loadUserByUsername(userDto.getEmail());
            if (existing != null) {
                result.rejectValue("email", null, "There is already an account registered with that email");
            }
        } catch (UsernameNotFoundException e) {}

        if (result.hasErrors()) {
            return "register.html";
        }

        customUserDetailsService.save(userDto);
        return "redirect:/registration?success";
    }
}
