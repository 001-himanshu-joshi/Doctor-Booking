package com.neet.Doctor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data
@Table(name = "Doctor_Details")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private Integer doctorId;
    @NotEmpty(message = "Name should not be Empty")
    @Column(name = "doctor_name")
    private String doctorName;
    @Email(message = "Enter valid Email")
    @Column(name = "doctor_email")
    private String doctorEmail;
    @Pattern(message = "First two digits will be the country code and next remaining digits will be number",regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[789]\\d{9}|(\\d[ -]?){10}\\d$")
    @Column(name = "contact_number")
    private String doctorPhoneNumber;
    @NotNull
    @Column(name = "experience")
    private Integer doctorExperience;
    @NotEmpty
    @Column(name = "specialization")
    private String specialization;


}
