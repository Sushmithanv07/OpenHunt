package com.nobroker.service.impl;

import com.nobroker.entity.Property;
import com.nobroker.payload.PropertyDto;
import com.nobroker.repository.PropertyRepository;
import com.nobroker.service.PropertyService;
import com.nobroker.util.PropertyMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    public PropertyServiceImpl(PropertyRepository propertyRepository, PropertyMapper propertyMapper) {
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }

    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto) {
        Property property = propertyMapper.dtoToEntity(propertyDto);
        property.setStatus("pending");
        Property savedProperty = propertyRepository.save(property);
        return propertyMapper.entityToDTO(savedProperty);
    }

    @Override
    public PropertyDto updatePropertyStatus(Long id, String newStatus) {
        Property property = propertyRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Property Not Found")
        );
//        property.setStatus(newStatus);
        Property updatedProperty = propertyRepository.save(property);
        return propertyMapper.entityToDTO(updatedProperty);
    }

    @Override
    public String findPropertyById(long id) {
//        Property property = propertyRepository.findById(id).get();
//        return property.getStatus();
    	return null;
    }
}
