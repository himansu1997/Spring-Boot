package com.dipl.exception;

public class PatientNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long patient_RegNo;
	public PatientNotFoundException(long patient_RegNo) {
	        super(String.format("Patient is not found with patient_RegNo : '%s'", patient_RegNo));
	      
	        }
}
