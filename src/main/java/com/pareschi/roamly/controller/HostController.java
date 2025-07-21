package com.pareschi.roamly.controller;

import com.pareschi.roamly.dto.UserDTO;
import com.pareschi.roamly.entity.Host;
import com.pareschi.roamly.service.HostService;
import com.pareschi.roamly.service.HostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/host")
@AllArgsConstructor
public class HostController {

    private HostService service;

    @GetMapping("/{id}")
    private ResponseEntity<Host> getHost(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchHost(id));
    }

    @PostMapping
    private ResponseEntity<Host> createHost(@RequestBody UserDTO dto) throws URISyntaxException {
        Host host = service.createHost(dto);
        return ResponseEntity.created(new URI("/host/" + host.getId())).body(host);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Host> updateHost(@PathVariable Long id, @RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.updateHost(id, dto));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteHost(@PathVariable Long id) {
        service.deleteHost(id);
        return ResponseEntity.ok().build();
    }
}
