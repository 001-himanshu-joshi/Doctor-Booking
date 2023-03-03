package com.neet.Doctor.service;

import com.neet.Doctor.dao.DoctorRepository;
import com.neet.Doctor.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctor() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getById(String doctorId) {
        List<Doctor> doctorlist;
        if (null != doctorId) {
            doctorlist = new ArrayList<>();
            doctorlist.add(doctorRepository.findById(Integer.valueOf(doctorId)).get());
        } else {
            doctorlist = doctorRepository.findAll();
        }
        return doctorlist;
    }

    public List<Doctor> getByExperience() {
        List<Doctor> doctorList = new ArrayList<>();
            for (Doctor doctor : doctorRepository.findAll()) {
                if (doctor.getDoctorExperience() >= 10) {
                    int id = doctor.getDoctorId();
                    doctorList.add(doctorRepository.findById(id).get());
                }
        }
        return doctorList;
    }
    public Doctor updateDoctor(Integer doctorId, String doctorName){
        List<Doctor> doctorList;
        Doctor doctor = null;
        if(null!=doctorId){
            doctorList = new ArrayList<>();
              doctorList.add(doctorRepository.findById(doctorId).get());
                  for(Doctor doc : doctorList){
                    doc.setDoctorName(doctorName);
                    doctor = doc;
              }
        }
        return doctor;
    }

    public void deleteDoctor(Integer doctorId) {
       if(null != doctorId){
           doctorRepository.deleteById(doctorId);
       }else{
           doctorRepository.deleteAll();
       }
    }
}
