package com.hospital.staffservice.repository;

import com.hospital.staffservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Spring génère la requête tout seul à partir du nom de la méthode :
    List<Doctor> findBySpeciality(String speciality);
    List<Doctor> findByDepartmentId(Long departmentId);
}
