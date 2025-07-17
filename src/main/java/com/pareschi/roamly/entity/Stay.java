package com.pareschi.roamly.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    @ManyToMany(mappedBy = "stays")
    private Set<Guest> guests;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Property property;
}
