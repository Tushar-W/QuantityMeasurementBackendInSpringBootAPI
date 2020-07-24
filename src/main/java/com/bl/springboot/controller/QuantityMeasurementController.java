package com.bl.springboot.controller;

import com.bl.springboot.enums.Unit;
import com.bl.springboot.model.Response;
import com.bl.springboot.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuantityMeasurementController {

    @Autowired
    QuantityService quantityService;

    @GetMapping("/unit")
    public String units(){
        return "Length";
    }

    @GetMapping("/units")
    public Response getUnitList(){
        return new Response(200,"Success", quantityService.getUnitList());
    }
}
