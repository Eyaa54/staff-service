package com.hospital.staffservice.controller;

import com.hospital.staffservice.client.AppointmentClient;
import com.hospital.staffservice.dto.AppointmentDTO;
import com.hospital.staffservice.entity.Doctor;
import com.hospital.staffservice.service.DoctorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class DoctorController {

    private final DoctorService service;
    private final AppointmentClient appointmentClient;

    public DoctorController(DoctorService service, AppointmentClient appointmentClient) {
        this.service = service;
        this.appointmentClient = appointmentClient;
    }

    @GetMapping
    public List<Doctor> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) { return service.create(doctor); }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable Long id, @RequestBody Doctor doctor) {
        return service.update(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Rechercher les médecins d'une spécialité donnée
    @GetMapping("/speciality/{speciality}")
    public List<Doctor> getBySpeciality(@PathVariable String speciality) {
        return service.getBySpeciality(speciality);
    }

    // INTEGRATION avec Appointment Service : les rendez-vous d'un médecin
    @GetMapping("/{id}/appointments")
    public List<AppointmentDTO> getDoctorAppointments(@PathVariable Long id) {
        return appointmentClient.getAppointmentsByDoctor(id);
    }
}
