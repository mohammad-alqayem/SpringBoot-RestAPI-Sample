package com.spring.restapi.controllers;

import com.spring.restapi.models.Room;
import com.spring.restapi.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "all")
    public ResponseEntity<Iterable<Room>> getAllRooms(){
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping(value = "room/{id}")
    public ResponseEntity<Object> getRoomById(@PathVariable("id") long id){
        Room room = roomService.getRoomById(id);
        if (room == null)
            return new ResponseEntity<>("Room not found!", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createRoom(@RequestBody Room room){
        roomService.createRoom(room);
        return new ResponseEntity<>("Room is Created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRoom(@PathVariable("id") long id){
        boolean result = roomService.deleteRoom(id);

        if (result)
            return new ResponseEntity<>("Room is deleted successfully", HttpStatus.OK);

        return new ResponseEntity<>("Room not found!", HttpStatus.NOT_FOUND);
    }
}
