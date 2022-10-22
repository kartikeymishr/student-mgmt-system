package com.kartikeymishr.studentmanagementsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/test")
    public ResponseEntity<String> testHelloWorld() {
        return ResponseEntity.ok("Hello World!");
    }
}
