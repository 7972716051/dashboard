package com.party.dashboard.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


    
  

    import com.party.dashboard.model.Party;
    import com.party.dashboard.model.User;

    import lombok.Data;


    @Data
    @Document(collection="party")
    public class Party {
        @MongoId
        String id;
        String firstName;
        String lastName;
        String dateOfBirth;
        Address address;
        ContactChannel contactChannel;
        String genderIdentity;
        String partyId;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public ContactChannel getContactChannel() {
			return contactChannel;
		}
		public void setContactChannel(ContactChannel contactChannel) {
			this.contactChannel = contactChannel;
		}
		public String getGenderIdentity() {
			return genderIdentity;
		}
		public void setGenderIdentity(String genderIdentity) {
			this.genderIdentity = genderIdentity;
		}
		public String getPartyId() {
			return partyId;
		}
		public void setPartyId(String partyId) {
			this.partyId = partyId;
		}

        
    }


