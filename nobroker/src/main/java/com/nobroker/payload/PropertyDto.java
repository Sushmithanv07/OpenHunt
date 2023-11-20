package com.nobroker.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {

    private Long id;
    private String propertyType;
    private String bhkType;
    private int floor;
    private int totalFloors;
    private int propertyAge;
    private String facing;
    private double builtUpArea;
    private String status;
}
