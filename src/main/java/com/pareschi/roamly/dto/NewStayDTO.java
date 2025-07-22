package com.pareschi.roamly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Data
public class NewStayDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Set<Long> guestsIds;
    private Long propertyId;
}
