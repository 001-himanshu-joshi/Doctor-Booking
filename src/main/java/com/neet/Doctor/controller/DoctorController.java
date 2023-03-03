package com.neet.Doctor.controller;

import com.neet.Doctor.model.Doctor;
import com.neet.Doctor.service.DoctorService;
import com.neet.Doctor.util.DoctorValidations;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/postDoctor")
    public ResponseEntity<String> saveDoctor(@Valid @RequestBody String doctor){
        JSONObject json = new JSONObject(doctor);
        Doctor newDoctor = DoctorValidations.setDoctor(json);
        doctorService.saveDoctor(newDoctor);
        return new ResponseEntity<>("Doctor is Added", HttpStatus.CREATED);
    }


    @GetMapping("/getDoctor")
    public List<Doctor> getById(@Nullable @RequestParam String doctorId){
        return doctorService.getById(doctorId);
    }

    @GetMapping("/getByExperience")
    public List<Doctor> getByExperience(){
        return  doctorService.getByExperience();
    }

    @PutMapping("/updateDoctor")
    public Doctor updateDoctor(@Nullable @RequestParam Integer doctorId, @PathVariable String doctorName){
        return doctorService.updateDoctor(doctorId,doctorName);
    }
    @DeleteMapping("/deleteDoctor")
    public void deleteDoctor(@Nullable @RequestParam Integer doctorId){
       doctorService.deleteDoctor(doctorId);
    }

}
