package com.thlogistic.organization.adapters.repositories;

import com.thlogistic.organization.entities.OrganizationEntity;
import com.thlogistic.organization.ports.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final MongoOrganizationRepository repository;

    @Override
    public String insert(OrganizationEntity Route) {
        return null;
    }

    @Override
    public String save(OrganizationEntity Route) {
        return null;
    }

    @Override
    public Optional<OrganizationEntity> findById(String id) {
        return Optional.empty();
    }

    @Override
    public BasePagingQueryResult<List<OrganizationEntity>> list(String keyword, Integer page, Integer size) {
        return null;
    }
}
