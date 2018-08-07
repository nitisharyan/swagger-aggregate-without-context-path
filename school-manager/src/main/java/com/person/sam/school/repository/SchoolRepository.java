package com.person.sam.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.person.sam.school.model.School;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {

}
