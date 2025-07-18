package com.pareschi.roamly.repository;


import com.pareschi.roamly.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    boolean existsByEmail(String email);
}
