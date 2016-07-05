package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Easy to retrieve an access token using:
 * {@code curl -X POST -vu acme:acmesecret http://localhost:9999/uaa/oauth/token -H "Accept: application/json" -d "password=spring&username=test&grant_type=password&scope=openid&client_secret=acmesecret&client_id=acme" }
 *
 * Then, send the access token to an OAuth2 secured REST resource using:
 * {@code curl http://localhost:9000/hi -H "Authorization: Bearer _INSERT TOKEN_"}
 */
@SpringBootApplication
@EnableResourceServer
@RestController
public class SsoAuthServerApplication {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(SsoAuthServerApplication.class, args);
    }
}
