package com.thlogistic.organization.core.usecases;

import com.thlogistic.organization.adapters.dtos.GetOrganizationResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetOrganizationUseCase extends BaseUseCase<String, GetOrganizationResponse> {
}
