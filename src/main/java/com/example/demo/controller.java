package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@SpringBootApplication

@RestController


public class controller {

    @RequestMapping("/app")
    
    public String outData () {
        return "Hola mundo cruel!";
    }

    @RequestMapping("/ayuda")
    public String ayuda (HttpServletRequest req, HttpServletResponse resp) {
        String params = StreamSupport.stream(
            ((Iterable<String>) () -> req.getParameterNames().asIterator()).spliterator(), false)
            .map(pName -> pName + '=' + req.getParameter(pName))
            .collect(Collectors.joining("&"));
            // resp.getWriter().write(params);
            return "<h1>" + req.getRequestURI() + '?' + HtmlUtils.htmlEscape(params) + "</h1>";      
    }
}
