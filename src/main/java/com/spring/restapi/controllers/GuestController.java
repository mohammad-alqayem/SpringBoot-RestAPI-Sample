package com.spring.restapi.controllers;

import com.spring.restapi.models.Guest;
import com.spring.restapi.service.GuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping(value = "all")
    public ResponseEntity<Iterable<Guest>> getAllGuests(){
        return new ResponseEntity<>(guestService.getAllGuests(), HttpStatus.OK);
    }

}
