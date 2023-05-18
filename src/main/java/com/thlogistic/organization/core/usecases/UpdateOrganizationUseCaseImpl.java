package com.thlogistic.organization.core.usecases;

import com.thlogistic.organization.adapters.dtos.UpdateOrganizationRequest;
import com.thlogistic.organization.aop.exception.DataNotFoundException;
import com.thlogistic.organization.core.entities.Organization;
import com.thlogistic.organization.core.entities.OrganizationType;
import com.thlogistic.organization.core.entities.ProviderType;
import com.thlogistic.organization.core.ports.OrganizationRepository;
import com.thlogistic.organization.infrastructure.persistence.entities.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateOrganizationUseCaseImpl implements UpdateOrganizationUseCase {

    private final OrganizationRepository repository;

    @Override
    public Object execute(Pair<String, UpdateOrganizationRequest> requestPair) {
        Optional<OrganizationEntity> entity = repository.findById(requestPair.getFirst());
        if (entity.isEmpty()) {
            throw new DataNotFoundException(Organization.class.getSimpleName());
        }

        UpdateOrganizationRequest request = requestPair.getSecond();
        OrganizationType organizationType = OrganizationType.fromInt(request.getType());

        OrganizationEntity result = entity.get();

        result.setName(request.getName());
        result.setCreditCard(request.getCreditCard());
        result.setContactName(request.getContactName());
        result.setContactNumber(request.getContactNumber());
        result.setType(organizationType);
        if (organizationType == OrganizationType.PROVIDER) {
            ProviderType providerType = ProviderType.fromInt(request.getProviderType());
            result.setProviderType(providerType);
        } else {
            result.setProviderType(null);
        }

        repository.save(result);
        return null;
    }
}
