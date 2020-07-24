package com.bl.springboot.service;

import com.bl.springboot.enums.Unit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuantityService {

    public List<Unit> getUnitList() {
        List<Unit> units = new ArrayList<>();
        Arrays.stream(Unit.values()).forEach(unitList -> units.add(unitList));
        return units;
    }
}
