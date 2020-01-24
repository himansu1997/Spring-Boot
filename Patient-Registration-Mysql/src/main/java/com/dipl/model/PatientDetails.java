package com.dipl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="patient_details")
public class PatientDetails {
	
	    @Id
	    @GeneratedValue
	    private Long patient_RegNo;
	@NotBlank
	    private String patient_Name;
	@NotBlank
	    private String patient_Address;

	public PatientDetails(){
	        super();
	    }
	public PatientDetails(Long patient_RegNo, String patient_Name, String patient_Address) {
	        super();
	        this.patient_RegNo = patient_RegNo;
	        this.patient_Name = patient_Name;
	        this.patient_Address = patient_Address;
	     
	    }
	/**
	 * @return the patient_RegNo
	 */
	public Long getPatient_RegNo() {
		return patient_RegNo;
	}
	/**
	 * @param patient_RegNo the patient_RegNo to set
	 */
	public void setPatient_RegNo(Long patient_RegNo) {
		this.patient_RegNo = patient_RegNo;
	}
	/**
	 * @return the patient_Name
	 */
	public String getPatient_Name() {
		return patient_Name;
	}
	/**
	 * @param patient_Name the patient_Name to set
	 */
	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}
	/**
	 * @return the patient_Address
	 */
	public String getPatient_Address() {
		return patient_Address;
	}
	/**
	 * @param patient_Address the patient_Address to set
	 */
	public void setPatient_Address(String patient_Address) {
		this.patient_Address = patient_Address;
	}
	
	

}
