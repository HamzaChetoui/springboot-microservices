package com.microservice.compute.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping("/compute")
public class ComputeController {

    @GetMapping("/multiple")
    public double multiply(@RequestParam double a,@RequestParam double b){
        return a*b;
    }

}
