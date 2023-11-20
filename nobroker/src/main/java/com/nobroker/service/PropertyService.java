package com.nobroker.service;

import com.nobroker.payload.PropertyDto;

public interface PropertyService {
    PropertyDto saveProperty(PropertyDto propertyDto);
    PropertyDto updatePropertyStatus(Long id, String newStatus);

    String findPropertyById(long id);
}
