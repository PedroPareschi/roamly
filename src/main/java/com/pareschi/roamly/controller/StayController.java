package com.pareschi.roamly.controller;

import com.pareschi.roamly.dto.NewStayDTO;
import com.pareschi.roamly.dto.StayDTO;
import com.pareschi.roamly.entity.Stay;
import com.pareschi.roamly.service.StayService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/stay")
@AllArgsConstructor
public class StayController {

    private StayService service;

    @GetMapping("/{id}")
    private ResponseEntity<Stay> getStay(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchStay(id));
    }

    @PostMapping
    private ResponseEntity<Stay> createStay(@RequestBody NewStayDTO dto) throws URISyntaxException {
        Stay stay = service.createStay(dto);
        return ResponseEntity.created(new URI("/stay/" + stay.getId())).body(stay);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Stay> updateStay(@PathVariable Long id, @RequestBody StayDTO dto) {
        return ResponseEntity.ok(service.updateStay(id, dto));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteStay(@PathVariable Long id) {
        service.deleteStay(id);
        return ResponseEntity.ok().build();
    }
}
