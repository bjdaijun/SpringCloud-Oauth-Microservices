package com.example;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@EnableDiscoveryClient
public class GridController {

    @RequestMapping("/")
    public @ResponseBody String getGrid() {
        // TODO implement real case
        return "3x3";
    }
}
