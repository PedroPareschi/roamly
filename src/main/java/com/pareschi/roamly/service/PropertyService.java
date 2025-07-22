package com.pareschi.roamly.service;

import com.pareschi.roamly.dto.PropertyDTO;
import com.pareschi.roamly.entity.Host;
import com.pareschi.roamly.entity.Property;
import com.pareschi.roamly.entity.enums.TypeOfProperty;
import com.pareschi.roamly.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class PropertyService {

    private PropertyRepository repository;
    private HostService hostService;

    public Property searchProperty(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found for id: " + id));
    }

    public Property createProperty(PropertyDTO dto) {
        TypeOfProperty typeOfProperty = TypeOfProperty.valueOf(dto.getTypeOfProperty().toUpperCase());
        Property newProperty = new Property();
        newProperty.setTypeOfProperty(typeOfProperty);
        newProperty.setAddress(dto.getAddress());
        Set<Host> hosts = hostService.getHosts(dto.getHostIds());
        if (hosts.isEmpty()) {
            throw new EntityNotFoundException("At least one of the hosts were not found");
        }
        newProperty.setHosts(hosts);
        return repository.save(newProperty);
    }

    public Property updateProperty(Long id, PropertyDTO dto) {
        TypeOfProperty typeOfProperty = TypeOfProperty.valueOf(dto.getTypeOfProperty().toUpperCase());
        Property newProperty = searchProperty(id);
        newProperty.setTypeOfProperty(typeOfProperty);
        newProperty.setAddress(dto.getAddress());
        Set<Host> hosts = hostService.getHosts(dto.getHostIds());
        if (!hosts.isEmpty()) {
            newProperty.setHosts(hosts);
        }
        return repository.save(newProperty);
    }

    public void deleteProperty(Long id) {
        searchProperty(id);
        repository.deleteById(id);
    }
}