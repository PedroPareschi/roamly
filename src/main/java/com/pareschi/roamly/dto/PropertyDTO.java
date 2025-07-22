package com.pareschi.roamly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class PropertyDTO {

    private String address;
    private String typeOfProperty;
    private Set<Long> hosts;
}
