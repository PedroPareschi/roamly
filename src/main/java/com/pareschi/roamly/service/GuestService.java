package com.pareschi.roamly.service;

import com.pareschi.roamly.dto.UserDTO;
import com.pareschi.roamly.entity.Guest;
import com.pareschi.roamly.repository.GuestRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class GuestService {

    private GuestRepository repository;

    public Guest searchGuest(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found for id: " + id));
    }

    public Guest createGuest(UserDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new EntityExistsException("Entity with email " + dto.getEmail() + " already exists");
        }
        Guest newGuest = new Guest();
        newGuest.setName(dto.getName());
        newGuest.setEmail(dto.getEmail());
        newGuest.setAddress(dto.getAddress());
        newGuest.setPassword(dto.getPassword());
        newGuest.setIdNumber(dto.getIdNumber());
        newGuest.setPhoneNumber(dto.getPhoneNumber());
        return repository.save(newGuest);
    }

    public Guest updateGuest(Long id, UserDTO dto) {
        Guest guest = searchGuest(id);
        guest.setName(dto.getName());
        guest.setEmail(dto.getEmail());
        guest.setAddress(dto.getAddress());
        guest.setPassword(dto.getPassword());
        guest.setIdNumber(dto.getIdNumber());
        guest.setPhoneNumber(dto.getPhoneNumber());
        return repository.save(guest);
    }

    public void deleteGuest(Long id) {
        searchGuest(id);
        repository.deleteById(id);
    }

    public Set<Guest> getGuests(Set<Long> guestsIds) {
        return new HashSet<>(repository.findAllById(guestsIds));
    }
}
