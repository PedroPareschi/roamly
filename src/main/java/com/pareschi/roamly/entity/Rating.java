package com.pareschi.roamly.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private double stars;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "rated_guest")
    private Guest guest;
    @ManyToOne
    @JoinColumn(name = "rated_host")
    private Host host;
    @ManyToOne
    @JoinColumn(name = "rated_property")
    private Property property;

    public void rating(double stars) {
        if (stars < 0.5 || stars > 5) {
            throw new RuntimeException("Invalid rating number: must be from 0.5 to 5");
        }
        this.stars = stars;
    }
}
