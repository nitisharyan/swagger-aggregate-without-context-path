package com.person.organization.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.person.organization.model.Organization;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization, String> {

}
