package com.hospital.staffservice.service;

import com.hospital.staffservice.entity.Shift;
import com.hospital.staffservice.repository.ShiftRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShiftService {
    private final ShiftRepository repo;
    public ShiftService(ShiftRepository repo) { this.repo = repo; }

    public List<Shift> getAll() { return repo.findAll(); }
    public Shift create(Shift s) { return repo.save(s); }
    public List<Shift> getByDoctor(Long doctorId) { return repo.findByDoctorId(doctorId); }
    public void delete(Long id) { repo.deleteById(id); }
}
