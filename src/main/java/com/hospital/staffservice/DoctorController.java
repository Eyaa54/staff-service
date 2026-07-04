package com.hospital.staffservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class DoctorController {
    @Autowired private DoctorRepository repo;

    @GetMapping
    public List<Doctor> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return repo.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}