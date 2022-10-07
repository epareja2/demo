package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.midi.Soundbank;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;
 
@SpringBootApplication

@RestController


public class controller {

    @RequestMapping("/app")
    
    public String outData () {
        return "Hola mundo cruel!";
    }

    @RequestMapping("/ayuda")
    public String ayuda (HttpServletRequest req) {
        String params = StreamSupport.stream(
            ((Iterable<String>) () -> req.getParameterNames().asIterator()).spliterator(), false)
            .map(pName -> pName + '=' + req.getParameter(pName))
            .collect(Collectors.joining("&"));
            return req.getRequestURI() + '?' + params;      
    }
}
