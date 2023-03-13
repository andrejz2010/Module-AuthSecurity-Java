package com.example.moduleauthsecurityjava.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.moduleauthsecurityjava.models.PhoneNumberRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {
    @PostMapping("/phone-number")
    public String phoneNumberSubmit(@ModelAttribute PhoneNumberRequest request) {
        System.out.println("\033[96mThe user submitted the phone number: " + request.getPhone());
        return "Successful!";
    }
}
