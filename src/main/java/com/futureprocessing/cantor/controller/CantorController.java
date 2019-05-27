package com.futureprocessing.cantor.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cantor/exchange")
@RestController
public class CantorController {

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping
    public String getCantor() {
        return "cantor";
    }
}
