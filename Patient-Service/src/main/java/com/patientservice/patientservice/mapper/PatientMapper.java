package com.patientservice.patientservice.mapper;

import com.patientservice.patientservice.dto.PatientRequestDTO;
import com.patientservice.patientservice.dto.PatientResponseDTO;
import com.patientservice.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toPatientResponseDTO(Patient patient){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setPhone(patient.getPhone());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setGender(patient.getGender());
        patientResponseDTO.setBloodGroup(patient.getBloodGroup());
        patientResponseDTO.setDob(patient.getDob().toString());
        patientResponseDTO.setAdmissionDate(patient.getAdmissionDate().toString());
        patientResponseDTO.setStatus(patient.getStatus());
        return patientResponseDTO;
    }

    public static Patient toPatient(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setPhone(patientRequestDTO.getPhone());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setGender(patientRequestDTO.getGender());
        patient.setBloodGroup(patientRequestDTO.getBloodGroup());
        patient.setStatus(patientRequestDTO.getStatus());
        patient.setDob(LocalDate.parse(patientRequestDTO.getDob()));
    return patient;}
}
