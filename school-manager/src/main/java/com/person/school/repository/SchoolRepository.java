package com.person.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.person.school.model.School;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {

}
