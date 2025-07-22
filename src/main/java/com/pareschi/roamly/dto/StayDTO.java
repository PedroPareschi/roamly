package com.pareschi.roamly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Data
public class StayDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
