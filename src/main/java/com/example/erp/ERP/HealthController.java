package com.example.erp.ERP;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Mini ERP Backend rodando 🚀";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}

