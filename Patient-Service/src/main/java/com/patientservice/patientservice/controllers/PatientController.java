package com.patientservice.patientservice.controllers;


import com.patientservice.patientservice.dto.PatientRequestDTO;
import com.patientservice.patientservice.dto.PatientResponseDTO;
import com.patientservice.patientservice.model.Patient;
import com.patientservice.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient Controller", description = "Patient Controller")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients(){
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @PostMapping("/save")
    @Operation(summary = "Save patient")
    public ResponseEntity<PatientResponseDTO> savePatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.ok().body(patientService.savePatient(patientRequestDTO));
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update patient")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Valid @RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.ok().body(patientService.updatePatient(id, patientRequestDTO));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient by id")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable UUID id){
        return ResponseEntity.ok().body(patientService.getPatientById(id));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete patient by id")
    public void deletePatientById(@PathVariable UUID id){
        patientService.deletePatientById(id);
    }




}
