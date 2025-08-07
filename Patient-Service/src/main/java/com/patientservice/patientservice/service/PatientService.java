package com.patientservice.patientservice.service;

import com.patientservice.patientservice.dto.PatientRequestDTO;
import com.patientservice.patientservice.dto.PatientResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO savePatient(PatientRequestDTO patientRequestDTO);

    PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO);

    PatientResponseDTO getPatientById(UUID id);

    void deletePatientById(UUID id);
}
