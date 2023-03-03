package com.neet.Doctor.dao;

import com.neet.Doctor.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository  extends JpaRepository<Patient, Integer>{

}

