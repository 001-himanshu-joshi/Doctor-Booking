package com.neet.Doctor.util;

import com.neet.Doctor.dao.DoctorRepository;
import com.neet.Doctor.model.Doctor;
import com.neet.Doctor.model.Patient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class PatientValidations {

    @Autowired
    static
    DoctorRepository doctorRepository;

    public static Patient setPatient(JSONObject json) {
        Patient patient = new Patient();

        patient.setPatientId(json.getInt("patientId"));
        patient.setPatientName(json.getString("patientName"));
        patient.setAge(json.getInt("age"));
        patient.setPhoneNumber(json.getString("phoneNumber"));
        patient.setDiseaseType(json.getString("diseaseType"));
        patient.setGender(json.getString("gender"));

        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        patient.setAdmitDate(currTime);

        String doctorId = json.getString("doctorId");
        Doctor doctor = doctorRepository.findById(Integer.valueOf(doctorId)).get();
        patient.setDoctor(doctor);

        return patient;
    }
}
