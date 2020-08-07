package com.example.demo.controller;

import com.example.demo.dto.PrinterDto;
import com.example.demo.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
/*
    IntegrationService integrationService;
@Autowired
    public ApiController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }
    @GetMapping("/")
    public ResponseEntity<List<PrinterDto>> read(){
    return integrationService.read();
    }*/


private IntegrationService service;
@Autowired
public ApiController(IntegrationService service) {
        this.service = service;
        }




@GetMapping("/")
public ResponseEntity<List<PrinterDto>> read() {
        return  service.read();

        }
}
