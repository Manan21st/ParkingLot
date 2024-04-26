package org.projects_nj.services;

import org.projects_nj.exceptions.InvalidGateException;
import org.projects_nj.exceptions.InvalidVehicleException;
import org.projects_nj.models.Gate;
import org.projects_nj.models.Ticket;
import org.projects_nj.models.Vehicle;
import org.projects_nj.models.VehicleType;
import org.projects_nj.repositories.GateRepository;
import org.projects_nj.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public Ticket issueTicket(Long gateId, VehicleType vehicleType, String vehicleNumber, String ownerName) throws InvalidGateException, InvalidVehicleException{
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> optionalGate = gateRepository.findById(gateId);

        if(optionalGate.isEmpty()){
            throw new InvalidGateException("Invalid Gate Id");
        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByNumber(vehicleNumber);

        if(optionalVehicle.isEmpty()){
            throw new InvalidVehicleException("Invalid Vehicle Number");
        }

        Vehicle vehicle = optionalVehicle.get();
        vehicle.setOwnerName(ownerName);
        vehicle.setType(vehicleType);
        ticket.setVehicle(vehicle);

        return null;
    }
}
