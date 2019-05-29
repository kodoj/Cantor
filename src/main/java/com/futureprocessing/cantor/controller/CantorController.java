package com.futureprocessing.cantor.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cantor/exchange")
@Controller
public class CantorController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public String getCantor() {
        return "cantor";
    }
}
