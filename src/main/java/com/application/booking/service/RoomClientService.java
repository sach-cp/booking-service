package com.application.booking.service;

import com.application.booking.response.RoomResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface RoomClientService {
    boolean isRoomExistsAndAvailable(Long roomId, LocalDate checkIn, LocalDate checkOut);
    RoomResponse getByRoomId(Long roomId);
}