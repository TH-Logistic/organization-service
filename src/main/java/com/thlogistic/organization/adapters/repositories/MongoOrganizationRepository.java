package com.thlogistic.organization.adapters.repositories;

import com.thlogistic.organization.entities.OrganizationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoOrganizationRepository extends MongoRepository<OrganizationEntity, String> {
}
