package com.thlogistic.organization.core.usecases;

import com.thlogistic.organization.adapters.dtos.CreateOrganizationRequest;
import com.thlogistic.organization.adapters.dtos.CreateOrganizationResponse;
import com.thlogistic.organization.core.entities.OrganizationType;
import com.thlogistic.organization.core.entities.ProviderType;
import com.thlogistic.organization.core.ports.OrganizationRepository;
import com.thlogistic.organization.infrastructure.persistence.entities.entities.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrganizationUseCaseImpl implements CreateOrganizationUseCase {

    private final OrganizationRepository repository;

    @Override
    public CreateOrganizationResponse execute(CreateOrganizationRequest request) {
        // Check request
        OrganizationType organizationType = OrganizationType.fromInt(request.getType());

        OrganizationEntity entity;

        if (organizationType == OrganizationType.PROVIDER) {
            ProviderType providerType = ProviderType.fromInt(request.getProviderType());
            entity = new OrganizationEntity(
                    request.getCreditCard(),
                    request.getName(),
                    request.getContactName(),
                    request.getContactNumber(),
                    organizationType,
                    providerType
            );
        } else {
            entity = new OrganizationEntity(
                    request.getCreditCard(),
                    request.getName(),
                    request.getContactName(),
                    request.getContactNumber(),
                    organizationType,
                    null
            );
        }

        String id = repository.insert(entity);
        return new CreateOrganizationResponse(id);
    }
}
