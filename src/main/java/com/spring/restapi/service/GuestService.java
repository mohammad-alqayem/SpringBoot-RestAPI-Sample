package com.spring.restapi.service;

import com.spring.restapi.data.GuestRepository;
import com.spring.restapi.models.Guest;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Iterable<Guest> getAllGuests(){
        return guestRepository.findAll();
    }
}
