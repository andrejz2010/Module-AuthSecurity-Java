package com.example.moduleauthsecurityjava.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.moduleauthsecurityjava.models.PhoneNumberRequest;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {

    private static final int PHONE_NUMBER_LENGTH = 11;

    @PostMapping("/phone-number")
    public ResponseEntity<String> phoneNumberSubmit(@ModelAttribute PhoneNumberRequest request) {
        if (isValidPhoneNumber(request.getPhone())) {
            return ResponseEntity.ok("Successful!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid phone number format");
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            System.out.println("Empty or null phone number provided");
            return false;
        }
        if (phoneNumber.length() != PHONE_NUMBER_LENGTH) {
            System.out.println("Invalid length phone number format provided");
            return false;
        }
        if (phoneNumber.matches("[0-9]+")) {
            return true;
        }
        System.out.println("Invalid phone number format provided");
        return false;
    }
}
