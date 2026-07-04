package com.hospital.staffservice.controller;

import com.hospital.staffservice.entity.Department;
import com.hospital.staffservice.entity.Doctor;
import com.hospital.staffservice.service.DepartmentService;
import com.hospital.staffservice.service.DoctorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService service;
    private final DoctorService doctorService;

    public DepartmentController(DepartmentService service, DoctorService doctorService) {
        this.service = service;
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Department> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Department create(@RequestBody Department department) { return service.create(department); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Lister tous les médecins d'un service
    @GetMapping("/{id}/doctors")
    public List<Doctor> getDoctors(@PathVariable Long id) {
        return doctorService.getByDepartment(id);
    }
}
