package com.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Porali_S on 12/14/2016.
 */
@RestController
public class HealthController {

    @RequestMapping(value = "/health",method = RequestMethod.GET)
    @ResponseBody
    String health() {
        return "Service Running !!";
    }
}
