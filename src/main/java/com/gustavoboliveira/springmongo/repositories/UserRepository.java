package com.gustavoboliveira.springmongo.repositories;

import com.gustavoboliveira.springmongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
