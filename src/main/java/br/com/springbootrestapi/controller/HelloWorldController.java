/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pedro
 */
@RestController
public class HelloWorldController {
    
    @GetMapping("/hello-world/{param}")
    public String helloWorld(@PathVariable String param){
        if (param == null) {
            param = "world";
        }
        return "Hello, " + param + "!";
    }
    
    
}
