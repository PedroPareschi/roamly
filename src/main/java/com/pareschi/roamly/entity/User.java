package com.pareschi.roamly.entity;

import com.pareschi.roamly.entity.interfaces.Rateble;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class User {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String idNumber;
    private String phoneNumber;
    private String address;

}
