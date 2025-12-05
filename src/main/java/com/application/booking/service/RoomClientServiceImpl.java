package com.application.booking.service;

import com.application.booking.config.RoomServiceProperties;
import com.application.booking.response.RoomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@Slf4j
@Service
public class RoomClientServiceImpl implements RoomClientService {

    private final WebClient webClient;

    public RoomClientServiceImpl(RoomServiceProperties properties, WebClient.Builder builder) {
        this.webClient = builder.baseUrl(properties.getUrl()).build();
    }

    @Override
    public boolean isRoomExistsAndAvailable(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        return Boolean.TRUE.equals(webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/rooms/{roomId}/availability")
                        .queryParam("checkInDate", checkInDate)
                        .queryParam("checkOutDate", checkOutDate)
                        .build(roomId))
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }

    @Override
    public RoomResponse getByRoomId(Long roomId) {
        return webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/rooms/{roomId}")
                        .build(roomId))
                .retrieve()
                .bodyToMono(RoomResponse.class)
                .block();
    }
}
