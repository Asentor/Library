package org.steri.Library.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SubscriptionDto {
    private Long id;
    private UserDto user;
    private List<BookDto> books;
    private LocalDate startDate;
    private LocalDate endDate;
}
