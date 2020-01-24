package com.dipl.exception;

public class ProductNotfoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private long patient_RegNo;
	public ProductNotfoundException(long patient_RegNo) {
	        super(String.format("Patient is not found with patient_RegNo : '%s'", patient_RegNo));
	      
	        }

}
