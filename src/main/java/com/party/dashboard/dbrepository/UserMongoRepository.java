package com.party.dashboard.dbrepository;


import com.party.dashboard.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {

   @Query(value = "{username: ?0, password: ?1}")
    Optional<User> checkUsernameExistOrNot(String username, String password);
 }
