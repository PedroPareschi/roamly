package com.pareschi.roamly.repository;

import com.pareschi.roamly.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}
