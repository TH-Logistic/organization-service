package com.thlogistic.organization.core.usecases;

import com.thlogistic.organization.adapters.dtos.CreateOrganizationRequest;
import com.thlogistic.organization.adapters.dtos.CreateOrganizationResponse;
import com.thlogistic.organization.adapters.dtos.GetOrganizationResponse;
import com.thlogistic.organization.aop.exception.DataNotFoundException;
import com.thlogistic.organization.core.entities.Organization;
import com.thlogistic.organization.core.entities.OrganizationType;
import com.thlogistic.organization.core.entities.ProviderType;
import com.thlogistic.organization.core.ports.OrganizationRepository;
import com.thlogistic.organization.infrastructure.persistence.entities.OrganizationEntity;
import com.thlogistic.organization.mapper.OrganizationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetOrganizationUseCaseImpl implements GetOrganizationUseCase {

    private final OrganizationRepository repository;

    @Override
    public GetOrganizationResponse execute(String id) {
        Optional<OrganizationEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new DataNotFoundException(Organization.class.getSimpleName());
        }
        return OrganizationMapper.fromOrganizationToResponse(entity.get().toOrganization());
    }
}
