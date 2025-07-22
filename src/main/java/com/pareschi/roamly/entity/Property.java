package com.pareschi.roamly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pareschi.roamly.entity.enums.TypeOfProperty;
import com.pareschi.roamly.entity.interfaces.Rateble;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Property implements Rateble {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private TypeOfProperty typeOfProperty;
    @ManyToMany
    @JoinTable(
            name = "property_host",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "host_id")
    )
    private Set<Host> hosts;
    @OneToMany(mappedBy = "property")
    @JsonIgnore
    private Set<Stay> stays;
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }
}
