package com.party.dashboard.model;


import lombok.Data;

@Data
public class ContactChannel {
    String phoneNumber;
    String emailAddress;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
    
}
