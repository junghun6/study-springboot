package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class BasicController {

    @GetMapping("/")
    @ResponseBody
    String hello () {
        return "어서오세요!";
    }

    @GetMapping("/hi")
    String word () {
        return "index.html";
    }

    @GetMapping("/date")
    @ResponseBody
    String date () {
        LocalDate today = LocalDate.now();

        return "Today" + today.toString();
    }
}
