package com.pareschi.roamly.repository;

import com.pareschi.roamly.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
