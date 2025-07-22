package com.pareschi.roamly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pareschi.roamly.entity.interfaces.Rateble;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Host extends User implements Rateble{

    @ManyToMany(mappedBy = "hosts")
    @JsonIgnore
    private Set<Property> properties;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void addProperty(Property newProperty) {
        properties.add(newProperty);
    }
}
