package com.pareschi.roamly.controller;

import com.pareschi.roamly.dto.UserDTO;
import com.pareschi.roamly.entity.Guest;
import com.pareschi.roamly.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/guest")
@AllArgsConstructor
public class GuestController {

    private GuestService service;

    @GetMapping("/{id}")
    private ResponseEntity<Guest> getGuest(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchGuest(id));
    }

    @PostMapping
    private ResponseEntity<Guest> createGuest(@RequestBody UserDTO dto) throws URISyntaxException {
        Guest guest = service.createGuest(dto);
        return ResponseEntity.created(new URI("/guest/" + guest.getId())).body(guest);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.updateGuest(id, dto));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteGuest(@PathVariable Long id) {
        service.deleteGuest(id);
        return ResponseEntity.ok().build();
    }
}
