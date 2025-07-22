package com.pareschi.roamly.entity;

import com.pareschi.roamly.entity.interfaces.Rateble;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guest extends User implements Rateble{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "guests")
    private Set<Stay> stays;
    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private Set<Rating> ratings;


    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }
}
