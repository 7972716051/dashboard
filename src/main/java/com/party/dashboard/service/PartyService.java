package com.party.dashboard.service;


import com.party.dashboard.model.Party;
import com.party.dashboard.model.User;

import java.util.List;

public interface PartyService {

    Party saveParty(Party userData);
    Party getParty(String partyId);
    List<Party> getParties();
    User validateUser(String username, String password);
    User registerUser(User user);
    List<User> getUsers();
    Party updateParty(Party userData);
    void deleteParty(String id);
}
