package com.person.sam.organization.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.person.sam.organization.model.Organization;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization, String> {

}
