package com.thlogistic.organization.ports;


import com.thlogistic.organization.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.organization.entities.OrganizationEntity;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository {
    String insert(OrganizationEntity Route);

    String save(OrganizationEntity Route);

    Optional<OrganizationEntity> findById(String id);

    BasePagingQueryResult<List<OrganizationEntity>> list(String keyword, Integer page, Integer size);

}
