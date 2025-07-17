package com.pareschi.roamly.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeOfProperty {
    HOUSE("House"),
    APARTMENT("Apartment"),
    HOTEL("Hotel"),
    HOSTEL("Hostel"),
    TENT("Tent"),
    STUDIO("Studio"),
    BEDROOM("Bedroom");
    private String name;
}
