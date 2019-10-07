package com.techfinally.rabbitmq.controller;

import com.techfinally.rabbitmq.model.Mesage;
import com.techfinally.rabbitmq.service.MesageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tech Finally
 */
@RestController
@RequestMapping(value = "/api/v1/msgs")
public class EmailController {

    @Autowired
    MesageService mesageService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> sendMessage(@RequestBody Mesage msg) {
        System.out.println("Send Message: " + msg.toString());
        mesageService.sendMessage(msg);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
