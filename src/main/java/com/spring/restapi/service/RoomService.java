package com.spring.restapi.service;

import com.spring.restapi.data.RoomRepository;
import com.spring.restapi.models.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Iterable<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(long id){
        if (roomRepository.existsById(id))
            return roomRepository.findById(id).get();

        return null;
    }

    public void createRoom(Room room){
        roomRepository.save(room);
    }

    public boolean deleteRoom(long id){
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
