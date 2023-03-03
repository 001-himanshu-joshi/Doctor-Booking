package com.neet.Doctor.service;


import com.neet.Doctor.dao.PatientRepository;

import com.neet.Doctor.model.Patient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository repository;
    private PatientRepository re;

    public void savePatient(Patient patient) {
        repository.save(patient);
    }

    public JSONArray getPatient(){
        JSONArray patientArray = new JSONArray();
        List<Patient> patients = repository.findAll();
        for(Patient patient : patients){
            JSONObject json = new JSONObject();
            json.put("patientId", patient.getPatientId());
            json.put("patientName", patient.getPatientName());
            json.put("age", patient.getAge());
            json.put("phoneNumber", patient.getPhoneNumber());
            json.put("diseaseType", patient.getDiseaseType());
            json.put("gender", patient.getGender());
            json.put("admitDate", patient.getAdmitDate());
            json.put("doctor", patient.getDoctor().getDoctorId());
            patientArray.put(json);
        }
        return patientArray;
    }

    public Patient putPatient(String patientId, Patient patient) {
        Patient patient1 = null;
        if (null != patientId && repository.findById(Integer.valueOf(patientId)).isPresent()) {
            patient1 = repository.findById(Integer.valueOf(patientId)).get();
            patient1.setPatientName(patient.getPatientName());
            patient1.setAge(patient.getAge());
            patient1.setDiseaseType(patient.getDiseaseType());
            patient1.setPhoneNumber(patient.getPhoneNumber());
            patient1.setAdmitDate(patient.getAdmitDate());
        }
        return patient1;
    }


    public String delete(String patientId) {
        repository.deleteById(Integer.valueOf(patientId));
        return "Patient is deleted with patientId "+ patientId;
    }
}
