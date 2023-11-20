package com.nobroker.util;

import com.nobroker.entity.Property;
import com.nobroker.payload.PropertyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PropertyMapper {

    @Mapping(target = "id", ignore = true) // Ignore id during mapping (assuming it's generated)
    PropertyDto entityToDTO(Property property);

    Property dtoToEntity(PropertyDto propertyDto);
}
