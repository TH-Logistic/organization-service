package com.thlogistic.organization.adapters.repositories;


import com.thlogistic.organization.core.entities.OrganizationType;
import com.thlogistic.organization.infrastructure.persistence.entities.entities.OrganizationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface MongoOrganizationRepository extends MongoRepository<OrganizationEntity, String> {
    Page<OrganizationEntity> findByNameContainingIgnoreCaseOrContactNameContainingIgnoreCase(String name, String contactName, Pageable pageable);
    Page<OrganizationEntity> findByTypeIsInAndNameContainingIgnoreCaseOrContactNameContainingIgnoreCase(Collection<OrganizationType> types, String name, String contactName, Pageable pageable);
    Page<OrganizationEntity> findByTypeIsIn(Collection<OrganizationType> types, Pageable pageable);
}
