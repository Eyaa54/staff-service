package com.hospital.staffservice.controller;

import com.hospital.staffservice.entity.Shift;
import com.hospital.staffservice.service.ShiftService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    private final ShiftService service;
    public ShiftController(ShiftService service) { this.service = service; }

    @GetMapping
    public List<Shift> getAll() { return service.getAll(); }

    @PostMapping
    public Shift create(@RequestBody Shift shift) { return service.create(shift); }

    // Le planning d'un médecin
    @GetMapping("/doctor/{doctorId}")
    public List<Shift> getByDoctor(@PathVariable Long doctorId) {
        return service.getByDoctor(doctorId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
