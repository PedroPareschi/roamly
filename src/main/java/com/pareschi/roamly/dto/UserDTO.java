package com.pareschi.roamly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private String idNumber;
    private String phoneNumber;
    private String address;
}
