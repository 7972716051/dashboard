package com.party.dashboard.dbrepository;


import com.party.dashboard.model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyMongoRepository extends MongoRepository<Party, String> {

    Optional<Party> getByPartyId(String partyId);

    @Query(value = "{firstName:?0, lastName:?1}")
    Optional<Party> personExist(String firstName, String lastName);

}
