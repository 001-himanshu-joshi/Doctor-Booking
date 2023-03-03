package com.neet.Doctor.util;

import com.neet.Doctor.model.Doctor;
import org.json.JSONObject;

public class DoctorValidations {

    public static Doctor setDoctor(JSONObject json){
        Doctor doctor = new Doctor();
        doctor.setDoctorId(json.getInt("doctorId"));
        doctor.setDoctorName(json.getString("doctorName"));
        doctor.setSpecialization(json.getString("specialization"));
        doctor.setDoctorExperience(json.getInt("doctorExperience"));
        doctor.setDoctorEmail(json.getString("email"));
        doctor.setDoctorPhoneNumber(json.getString("phoneNumber"));
        return doctor;
    }


}
