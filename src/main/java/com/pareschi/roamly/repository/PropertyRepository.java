package com.pareschi.roamly.repository;

import com.pareschi.roamly.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
