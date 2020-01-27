package com.dipl.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dipl.controller.exception.PatientNotFoundException;
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
	  @PostMapping("/addpatient") public String createPatient(@Valid @RequestBody PatientDetails patient) { 
		  PatientDetails p = patientRepository.save(patient);
	  return "PATIENT DETAILS HAS BEEN ADDED SUCCESSFULLY"+"\n"+p; 
	  }
	 
    
//    @RequestMapping(value="/addpatient", method = RequestMethod.POST)  
//    	public String createPatient(@PathVariable("patient_Name") String patient_Name, @RequestBody PatientDetails patient) throws PatientNotFoundException{
//        if(!patientRepository.equals(patient_Name))throw new PatientNotFoundException();
//        //patientRepository.remove(id);
//        PatientDetails p = patientRepository.save(patient);
//        ((PatientDetails) patientRepository).setPatient_Name(patient_Name);
//        //patientRepository.put(id, patient);
//        return "ADDED PATIENT DETAILS"+"\n";
//     }
		
// Get a Single patient
    @GetMapping("/patient/{patient_RegNo}")
    public PatientDetails getPatientById(@PathVariable(value = "patient_RegNo") Long patient_RegNo) throws PatientNotFoundException {
    	return  patientRepository.findById(patient_RegNo).orElseThrow(() -> new PatientNotFoundException());
    }
    
    

// Update a Patient Record
    
    @PutMapping("/updatepatient/{patient_RegNo}")
    public String updatePatient(@PathVariable(value = "patient_RegNo") Long patient_RegNo,@Valid @RequestBody PatientDetails patientDetails) throws PatientNotFoundException {

PatientDetails patient = patientRepository.findById(patient_RegNo).orElseThrow(() -> new PatientNotFoundException());

patient.setPatient_Name(patientDetails.getPatient_Name());patient.setPatient_Address(patientDetails.getPatient_Address());


PatientDetails updatedPatientDetails = patientRepository.save(patient);
        //return updatedPatientDetails;
        
        return "PATIENT DETAILS HAS BEEN UPDATED SUCCESSFULLY"+"\n"+patientRepository.save(patient)+patient;
    }
    
    

// Delete a patient
    @DeleteMapping("/deletepatient/{patient_RegNo}")
    public String deleteBook(@PathVariable(value = "patient_RegNo") Long patient_RegNo) throws Exception {
        PatientDetails patient = patientRepository.findById(patient_RegNo).orElseThrow(() -> new PatientNotFoundException());
        patientRepository.delete(patient);
                      return "PATIENT RECORD HAS BEEN DELETED SUCCESSFULLY"+"\n";
    }

}
    
