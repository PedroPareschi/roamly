package com.pareschi.roamly.controller;


import com.pareschi.roamly.dto.PropertyDTO;
import com.pareschi.roamly.dto.UserDTO;
import com.pareschi.roamly.entity.Property;
import com.pareschi.roamly.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/property")
@AllArgsConstructor
public class PropertyController {

    private PropertyService service;

    @GetMapping("/{id}")
    private ResponseEntity<Property> getProperty(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchProperty(id));
    }

    @PostMapping
    private ResponseEntity<Property> createProperty(@RequestBody PropertyDTO dto) throws URISyntaxException {
        Property property = service.createProperty(dto);
        return ResponseEntity.created(new URI("/property/" + property.getId())).body(property);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody PropertyDTO dto) {
        return ResponseEntity.ok(service.updateProperty(id, dto));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        service.deleteProperty(id);
        return ResponseEntity.ok().build();
    }
}
