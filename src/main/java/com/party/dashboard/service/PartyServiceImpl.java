package com.party.dashboard.service;
import java.util.UUID;



import com.party.dashboard.dbrepository.PartyMongoRepository;
import com.party.dashboard.dbrepository.UserMongoRepository;
import com.party.dashboard.exception.DataExistException;
import com.party.dashboard.exception.DataNotFoundException;
import com.party.dashboard.model.Party;
import com.party.dashboard.model.User;



import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PartyServiceImpl implements PartyService {

    @Autowired
     PartyMongoRepository partyMongoRepository;
    @Autowired
     UserMongoRepository userMongoRepository;

    @Override
    public Party saveParty(Party userData) {

        Optional<Party> partyExistOrNot = partyMongoRepository.personExist(userData.getFirstName(), userData.getLastName());
        if(partyExistOrNot.isPresent()){
            throw new DataExistException("party already exist");
        }
        List<Party> parties = partyMongoRepository.findAll();
        userData.setPartyId(String.valueOf(parties.size() + 1)); 
        return partyMongoRepository.save(userData);
    }

 
    public PartyMongoRepository getPartyMongoRepository() {
		return partyMongoRepository;
	}


	public void setPartyMongoRepository(PartyMongoRepository partyMongoRepository) {
		this.partyMongoRepository = partyMongoRepository;
	}


	public UserMongoRepository getUserMongoRepository() {
		return userMongoRepository;
	}


	public void setUserMongoRepository(UserMongoRepository userMongoRepository) {
		this.userMongoRepository = userMongoRepository;
	}


	@Override
    public Party getParty(String partyId) {
        return partyMongoRepository.getByPartyId(partyId)
                .orElseThrow(() -> new DataNotFoundException("User not found with ID: " + partyId));

    }

    @Override
    public List<Party> getParties() {
        return partyMongoRepository.findAll();
    }

    @Override
    public User validateUser(String username, String password) {
        return userMongoRepository.checkUsernameExistOrNot(username, password)
                .orElseThrow(()->new DataNotFoundException("User not Found for username: "+username))
                ;
    }

    @Override
    public User registerUser(User user) {
        return userMongoRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userMongoRepository.findAll();
    }

    @Override
    public Party updateParty(Party userData) {
        return partyMongoRepository.save(userData);
    }

    @Override
    public void deleteParty(String id) {
        partyMongoRepository.deleteByPartyId(id);
    }
}
