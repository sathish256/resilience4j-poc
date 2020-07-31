package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BusinessService;

@RestController
@RequestMapping(value = "/backendB")
public class BackendBController {

    private final BusinessService businessBService;

    public BackendBController(@Qualifier("businessBService")BusinessService businessBService){
        this.businessBService = businessBService;
    }

    @GetMapping("failure")
    public String backendBFailure(){
        return businessBService.failure();
    }

    @GetMapping("success")
    public String backendBSuccess(){
        return businessBService.success();
    }

    @GetMapping("ignore")
    public String ignore(){
        return businessBService.ignore();
    }
}
