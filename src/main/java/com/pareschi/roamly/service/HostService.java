package com.pareschi.roamly.service;

import com.pareschi.roamly.dto.UserDTO;
import com.pareschi.roamly.entity.Host;
import com.pareschi.roamly.repository.HostRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class HostService {

    private HostRepository repository;

    public Host searchHost(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found for id: " + id));
    }

    public Host createHost(UserDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new EntityExistsException("Entity with email " + dto.getEmail() + " already exists");
        }
        Host newHost = new Host();
        newHost.setName(dto.getName());
        newHost.setEmail(dto.getEmail());
        newHost.setAddress(dto.getAddress());
        newHost.setPassword(dto.getPassword());
        newHost.setIdNumber(dto.getIdNumber());
        newHost.setPhoneNumber(dto.getPhoneNumber());
        return repository.save(newHost);
    }

    public Host updateHost(Long id, UserDTO dto) {
        Host host = searchHost(id);
        host.setName(dto.getName());
        host.setEmail(dto.getEmail());
        host.setAddress(dto.getAddress());
        host.setPassword(dto.getPassword());
        host.setIdNumber(dto.getIdNumber());
        host.setPhoneNumber(dto.getPhoneNumber());
        return repository.save(host);
    }

    public void deleteHost(Long id) {
        searchHost(id);
        repository.deleteById(id);
    }

    public Set<Host> getHosts(Set<Long> hostsId) {
        return new HashSet<>(repository.findAllById(hostsId));
    }
}
