package com.dipl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dipl.exception.PatientNotFoundException;
import com.dipl.model.PatientDetails;
import com.dipl.repository.PatientRepository;

@RestController
public class PatientController {
	
	@Autowired
    PatientRepository patientRepository;

// Get All Patient details
    @GetMapping("/allpatients")
    public List<PatientDetails> getAllPatients() {
        return patientRepository.findAll();
    }
    

      //Register a new patient
    @PostMapping("/addpatient")
    public PatientDetails createPatient(@Valid @RequestBody PatientDetails patient) {
        return patientRepository.save(patient);
    }
    
//    @PostMapping("/addpatient")
//    public String createPatient(@Valid @RequestBody PatientDetails patient) {
//        //return patientRepository.save(patient);
//        return "Details has been added sucessfully";
//    }
//    

// Get a Single patient
    @GetMapping("/patient/{patient_RegNo}")
    public PatientDetails getPatientById(@PathVariable(value = "patient_RegNo") Long patient_RegNo) throws PatientNotFoundException {
        return patientRepository.findById(patient_RegNo).orElseThrow(() -> new PatientNotFoundException(patient_RegNo));
    }

// Update a Patient
    @PutMapping("/updatepatient/{patient_RegNo}")
    public PatientDetails updatePatient(@PathVariable(value = "patient_RegNo") Long patient_RegNo,@Valid @RequestBody PatientDetails patientDetails) throws PatientNotFoundException {

PatientDetails patient = patientRepository.findById(patient_RegNo).orElseThrow(() -> new PatientNotFoundException(patient_RegNo));

patient.setPatient_Name(patientDetails.getPatient_Name());patient.setPatient_Address(patientDetails.getPatient_Address());


PatientDetails updatedPatientDetails = patientRepository.save(patient);
        return updatedPatientDetails;
    }

// Delete a patient
    @DeleteMapping("/books/{patient_RegNo}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "patient_RegNo") Long patient_RegNo) throws PatientNotFoundException {
        PatientDetails patient = patientRepository.findById(patient_RegNo).orElseThrow(() -> new PatientNotFoundException(patient_RegNo));

patientRepository.delete(patient);

return ResponseEntity.ok().build();
    }

}
