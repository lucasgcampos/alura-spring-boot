package com.springboot.lucascampos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class Configuration {

    public static void main(String[] args) {
        SpringApplication.run(Configuration.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "<h2>Hello Word!</h2>";
    }

}
