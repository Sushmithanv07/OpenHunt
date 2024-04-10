package com.nobroker.controller;

import com.nobroker.payload.PropertyDto;
import com.nobroker.payload.PropertyStatusUpdateRequest;
import com.nobroker.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<PropertyDto> addProperty(@RequestBody PropertyDto propertyDto) {
            PropertyDto savedProperty = propertyService.saveProperty(propertyDto);
            return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<PropertyDto> updatePropertyStatus(
//            @PathVariable Long id,
//            @RequestBody PropertyStatusUpdateRequest request){
//        PropertyDto updatedProperty = propertyService.updatePropertyStatus(id, request.getStatus());
//        return ResponseEntity.ok(updatedProperty);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getProperty(
            @PathVariable("id") long id
    ){
        String status  = getPropertyStatusFromDatabase(id);
        if("Approved".equals(status)){
            return ResponseEntity.ok("Property details: {\"status\" : \"Approved\"}");
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied. Property status must be approved");
        }
    }
    private String getPropertyStatusFromDatabase(long id){
        return  propertyService.findPropertyById(id);
    }

}
