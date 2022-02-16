package com.example.hellospring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class IndexController {


    @GetMapping("/yo")
    public String yo(){
        return "yo";
    }

    @GetMapping("/echo")
    public String echo(@RequestParam String text){
        return text;
    }

    @GetMapping("/ErDetFredag")
    public String fredag(){
        LocalDate date = LocalDate.now();
        String[] split = date.toString().split("-");
        int day = Integer.parseInt(split[2]);
        int month = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[0]);

        if (month == 1)
        {
            month = 13;
            year--;
        }
        if (month == 2)
        {
            month = 14;
            year--;
        }

        int q = day;
        int m = month;
        int j = year / 100;
        int k = year % 100;
        int h = (q + 13*(m + 1) / 5 + k + (k / 4) + (j / 4) + 5 * j) % 7;
        h = ((h+5)%7)+1;

        switch (h)
        {

            case 1 : return "No it's Monday";
            case 2 : return "No it's Tuesday";
            case 3 : return "No it's Wednesday";
            case 4 : return "No it's Thursday";
            case 5 : return "Yes it's Friday";
            case 6 : return "No it's Saturday";
            case 7 : return "No it's Sunday";

        }

        return null;
    }

}
