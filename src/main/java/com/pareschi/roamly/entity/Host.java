package com.pareschi.roamly.entity;

import com.pareschi.roamly.entity.interfaces.Rateble;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Host extends User implements Rateble{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Property> properties;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }
}
