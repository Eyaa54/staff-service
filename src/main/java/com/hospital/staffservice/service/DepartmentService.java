package com.hospital.staffservice.service;

import com.hospital.staffservice.entity.Department;
import com.hospital.staffservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repo;
    public DepartmentService(DepartmentRepository repo) { this.repo = repo; }

    public List<Department> getAll() { return repo.findAll(); }
    public Department getById(Long id) { return repo.findById(id).orElse(null); }
    public Department create(Department d) { return repo.save(d); }
    public void delete(Long id) { repo.deleteById(id); }
}
