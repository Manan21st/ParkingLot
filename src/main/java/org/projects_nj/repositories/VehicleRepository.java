package org.projects_nj.repositories;

import org.projects_nj.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public Optional<Vehicle> findByNumber(String vehicleNumber){
        if(vehicles.containsKey(vehicleNumber)){
            return Optional.of(vehicles.get(vehicleNumber));
        }
        return Optional.empty();
    }
}
