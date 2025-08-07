package com.patientservice.patientservice.service.impl;

import com.patientservice.patientservice.Exceptions.EmailAlreadyExists;
import com.patientservice.patientservice.Exceptions.PatientNotFoundException;
import com.patientservice.patientservice.Repository.PatientRepository;
import com.patientservice.patientservice.dto.PatientRequestDTO;
import com.patientservice.patientservice.dto.PatientResponseDTO;
import com.patientservice.patientservice.grpc.BillingServiceGrpcClient;
import com.patientservice.patientservice.mapper.PatientMapper;
import com.patientservice.patientservice.model.Patient;
import com.patientservice.patientservice.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Slf4j
@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final BillingServiceGrpcClient billingServiceGrpcClient;

    public PatientServiceImpl(PatientRepository patientRepository, BillingServiceGrpcClient billingServiceGrpcClient) {
        this.patientRepository = patientRepository;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll().stream().
                map(PatientMapper::toPatientResponseDTO).toList();

       }

    @Override
    public PatientResponseDTO  savePatient(PatientRequestDTO patientRequestDTO) {

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExists("Email already exists " + patientRequestDTO.getEmail());
        }
        Patient patient = patientRepository.save(PatientMapper.toPatient(patientRequestDTO));
        billingServiceGrpcClient.createBillingAccount(patient.getId().toString(), patient.getName(), patient.getEmail());
        return PatientMapper.toPatientResponseDTO(patient);
    }

    @Override
    public PatientResponseDTO updatePatient(UUID id , PatientRequestDTO patientRequestDTO) {

        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)) {
            throw new EmailAlreadyExists("Email already exists " + patientRequestDTO.getEmail());
        }

       Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + id));
       patient.setName(patientRequestDTO.getName());
       patient.setEmail(patientRequestDTO.getEmail());
       patient.setPhone(patientRequestDTO.getPhone());
       patient.setAddress(patientRequestDTO.getAddress());
       patient.setGender(patientRequestDTO.getGender());
       patient.setBloodGroup(patientRequestDTO.getBloodGroup());
       patient.setStatus(patientRequestDTO.getStatus());
       return PatientMapper.toPatientResponseDTO(patientRepository.save(patient));
    }

    @Override
    public PatientResponseDTO getPatientById(UUID id) {
        return patientRepository.findById(id).map(PatientMapper::toPatientResponseDTO).orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + id));
    }

    @Override
    public void deletePatientById(UUID id) {
        patientRepository.deleteById(id) ;
    }


}
