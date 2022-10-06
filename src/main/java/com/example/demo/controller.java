package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 
@SpringBootApplication

@Controller


public class controller {

    @RequestMapping("/app")
    public String outData () {
        System.out.println("Hola mundo cruel!");
        return "outData ";
    }
}
