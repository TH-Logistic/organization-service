package com.thlogistic.organization.adapters.repositories;

import com.thlogistic.organization.core.entities.OrganizationType;
import com.thlogistic.organization.core.ports.OrganizationRepository;
import com.thlogistic.organization.infrastructure.persistence.entities.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final MongoOrganizationRepository repository;

    @Override
    public String insert(OrganizationEntity organization) {
        return repository.insert(organization).getId();
    }

    @Override
    public String save(OrganizationEntity organization) {
        return repository.save(organization).getId();
    }

    @Override
    public Optional<OrganizationEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public BasePagingQueryResult<List<OrganizationEntity>> listWithTypes(String keyword, List<Integer> types, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OrganizationEntity> entities;

        List<OrganizationType> enumTypes = types.stream().map(OrganizationType::fromInt).toList();

        if (keyword == null || keyword.isEmpty()) {
            entities = repository.findByTypeIsIn(enumTypes, pageable);
        } else {
            entities = repository.findByTypeIsInAndNameContainingIgnoreCaseOrContactNameContainingIgnoreCase(enumTypes, keyword, keyword, pageable);
        }
        BasePagingQueryResult<List<OrganizationEntity>> result = new BasePagingQueryResult<>();
        result.data = entities.getContent();
        result.total = entities.getTotalElements();
        result.totalPage = entities.getTotalPages();
        return result;
    }

    @Override
    public BasePagingQueryResult<List<OrganizationEntity>> list(String keyword, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OrganizationEntity> entities;
        if (keyword == null || keyword.isEmpty()) {
            entities = repository.findAll(pageable);
        } else {
            entities = repository.findByNameContainingIgnoreCaseOrContactNameContainingIgnoreCase(keyword, keyword, pageable);
        }

        BasePagingQueryResult<List<OrganizationEntity>> result = new BasePagingQueryResult<>();
        result.data = entities.getContent();
        result.total = entities.getTotalElements();
        result.totalPage = entities.getTotalPages();
        return result;
    }
}
