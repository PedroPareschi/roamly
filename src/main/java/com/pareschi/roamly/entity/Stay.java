package com.pareschi.roamly.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToMany
    @JoinTable(name = "stay_guest",
            joinColumns =
            @JoinColumn(name = "stay_id"),
            inverseJoinColumns =
            @JoinColumn(name = "guest_id")
    )
    private Set<Guest> guests;
    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;
}
