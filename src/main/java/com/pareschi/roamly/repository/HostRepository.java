package com.pareschi.roamly.repository;

import com.pareschi.roamly.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface HostRepository extends JpaRepository<Host, Long> {
    boolean existsByEmail(String email);
}
