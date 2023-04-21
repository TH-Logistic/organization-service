package com.thlogistic.organization.core.ports;


import com.thlogistic.organization.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.organization.infrastructure.persistence.entities.entities.OrganizationEntity;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository {
    String insert(OrganizationEntity organization);

    String save(OrganizationEntity organization);

    Optional<OrganizationEntity> findById(String id);

    BasePagingQueryResult<List<OrganizationEntity>> listWithTypes(String keyword, List<Integer> types, Integer page, Integer size);
    BasePagingQueryResult<List<OrganizationEntity>> list(String keyword, Integer page, Integer size);

}
