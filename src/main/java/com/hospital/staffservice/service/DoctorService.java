package com.hospital.staffservice.service;

import com.hospital.staffservice.entity.Doctor;
import com.hospital.staffservice.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository repo;
    public DoctorService(DoctorRepository repo) { this.repo = repo; }

    public List<Doctor> getAll() { return repo.findAll(); }
    public Doctor getById(Long id) { return repo.findById(id).orElse(null); }
    public Doctor create(Doctor d) { return repo.save(d); }

    public Doctor update(Long id, Doctor d) {
        d.setId(id);              // on force l'id pour mettre à jour la bonne ligne
        return repo.save(d);
    }

    public void delete(Long id) { repo.deleteById(id); }
    public List<Doctor> getBySpeciality(String s) { return repo.findBySpeciality(s); }
    public List<Doctor> getByDepartment(Long deptId) { return repo.findByDepartmentId(deptId); }
}
