package com.example.web_angular_spring_rest.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
@SessionScope
public class AuthenticationController {

    @GetMapping(value = "/authenticate",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MessageToken> get() {
        return new ResponseEntity<>(
                new MessageToken(RequestContextHolder.currentRequestAttributes().getSessionId()),
                HttpStatus.OK);
    }

    private static class MessageToken {

        String token;

        public MessageToken(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}

