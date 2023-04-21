package com.thlogistic.organization.core.usecases;

import com.thlogistic.organization.adapters.dtos.UpdateOrganizationRequest;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public interface UpdateOrganizationUseCase extends BaseUseCase<Pair<String, UpdateOrganizationRequest>, Object> {
}
