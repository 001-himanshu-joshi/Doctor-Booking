package com.neet.Doctor.controller;



import com.neet.Doctor.dao.DoctorRepository;
import com.neet.Doctor.model.Doctor;
import com.neet.Doctor.model.Patient;
import com.neet.Doctor.service.PatientService;
import com.neet.Doctor.util.PatientValidations;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.Timestamp;



@RestController
@RequestMapping("/api/v2")
public class PatientController {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientService service;

    @PostMapping("/patient")
    public String savePatient(@RequestBody String patientRequest) {
        JSONObject json = new JSONObject(patientRequest);
        Patient patient = PatientValidations.setPatient(json);
        service.savePatient(patient);
        return "Saved patient";
    }

    @GetMapping("/getPatient")
    public ResponseEntity getPatients(@Nullable @RequestParam String doctorId, @Nullable @RequestParam String patientId){
      JSONArray jsonArray = service.getPatient();
      return  new ResponseEntity<>(jsonArray.toString(), HttpStatus.OK);
    }

    @PutMapping("updatePatient/{patientId}")
    public Patient update(@Nullable @RequestParam String patientId, @RequestBody String patientData){
        JSONObject json = new JSONObject(patientData);
        Patient patient = PatientValidations.setPatient(json);
        return service.putPatient(patientId, patient);
    }

    @DeleteMapping("deletePatient/{patientId}")
    public String deletePatient(@PathVariable String patientId){
        return service.delete(patientId);
    }


}
