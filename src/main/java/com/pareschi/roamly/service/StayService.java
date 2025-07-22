package com.pareschi.roamly.service;

import com.pareschi.roamly.dto.NewStayDTO;
import com.pareschi.roamly.dto.StayDTO;
import com.pareschi.roamly.entity.Guest;
import com.pareschi.roamly.entity.Stay;
import com.pareschi.roamly.repository.StayRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class StayService {

    private StayRepository repository;
    private GuestService guestService;
    private PropertyService propertyService;

    public Stay searchStay(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found for id: " + id));
    }

    public Stay createStay(NewStayDTO dto) {
        Stay newStay = new Stay();
        newStay.setStartDate(dto.getStartDate());
        newStay.setEndDate(dto.getEndDate());
        Set<Guest> guests = guestService.getGuests(dto.getGuestsIds());
        if (guests.isEmpty()) {
            throw new EntityNotFoundException("No guests accounts found for ids: " + dto.getGuestsIds());
        }
        newStay.setProperty(propertyService.searchProperty(dto.getPropertyId()));
        return repository.save(newStay);
    }

    public Stay updateStay(Long id, StayDTO dto) {
        Stay stay = searchStay(id);
        stay.setStartDate(dto.getStartDate());
        stay.setEndDate(dto.getEndDate());
        return repository.save(stay);
    }

    public void deleteStay(Long id) {
        searchStay(id);
        repository.deleteById(id);
    }
}