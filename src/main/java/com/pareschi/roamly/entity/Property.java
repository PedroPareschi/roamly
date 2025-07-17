package com.pareschi.roamly.entity;

import com.pareschi.roamly.entity.enums.TypeOfProperty;
import com.pareschi.roamly.entity.interfaces.Rateble;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Property implements Rateble {

    private String address;
    private TypeOfProperty typeOfProperty;
    @ManyToMany(mappedBy = "properties")
    private Set<Host> hosts;
    @OneToMany(mappedBy = "property")
    private Set<Stay> stays;
    @OneToMany(mappedBy = "ratedProperty", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }
}
