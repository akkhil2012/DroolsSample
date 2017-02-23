package com.ikare.finance;

import java.io.Serializable;



public class Finance implements Serializable {
	private static final long serialVersionUID = 1L;
	private long budget;
	
	public boolean isCheckMemoValid() {
		return checkMemoValid;
	}

	public void setCheckMemoValid(boolean checkMemoValid) {
		this.checkMemoValid = checkMemoValid;
	}

	private boolean checkMemoValid=false;
	public long getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(long countryCode) {
		this.countryCode = countryCode;
	}

	private long countryCode;
	
	

	public long getEmployeeCost() {
		return employeeCost;
	}

	public void setEmployeeCost(long employeeCost) {
		this.employeeCost = employeeCost;
	}

	private long employeeCost;

	

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	/*public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public String toString() {
		return "Memo to be gnerated is for  [budget=" + budget + ", country=" + countryCode+ "]";
	}
}