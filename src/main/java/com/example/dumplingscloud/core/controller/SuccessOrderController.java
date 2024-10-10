package com.example.dumplingscloud.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessOrderController {
    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
