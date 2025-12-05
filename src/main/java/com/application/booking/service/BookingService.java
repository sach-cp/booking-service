package com.application.booking.service;

import com.application.booking.dto.BookingDto;
import com.application.booking.response.BookingResponse;
import com.application.booking.response.BookingSummaryResponse;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    String createBooking(BookingDto booking, Long roomId);
    BookingResponse getBooking(Long bookingId);
    List<BookingSummaryResponse> getAllBookingsByDate(LocalDate bookingDate);
    String updateBooking(BookingDto bookingDto, Long bookingId);
    String deleteBooking(Long bookingId);

    List<BookingSummaryResponse> getAllBookingsByDateRange(LocalDate fromDate, LocalDate toDate);
}
