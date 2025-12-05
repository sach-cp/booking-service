package com.application.booking.validation;

import com.application.booking.dto.BookingDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, BookingDto> {
    @Override
    public boolean isValid(BookingDto booking, ConstraintValidatorContext context) {
        boolean valid = booking.getCheckOutDate().isAfter(booking.getCheckInDate());
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Check-out date must be after check-in date")
                    .addPropertyNode("checkOutDate")
                    .addConstraintViolation();
        }
        return valid;
    }
}
