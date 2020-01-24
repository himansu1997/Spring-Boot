package com.dipl.exception;

public class PatientNotFoundException extends Exception {
	
	private long patient_RegNo;
	public PatientNotFoundException(long patient_RegNo) {
	        super(String.format("Patient is not found with patient_RegNo : '%s'", patient_RegNo));
	        }
}
