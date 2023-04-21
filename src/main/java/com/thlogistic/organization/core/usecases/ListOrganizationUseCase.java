package com.thlogistic.organization.core.usecases;

import com.thlogistic.organization.adapters.dtos.BasePagingResponse;
import com.thlogistic.organization.adapters.dtos.GetOrganizationResponse;
import com.thlogistic.organization.adapters.dtos.ListOrganizationPagingRequest;
import org.springframework.stereotype.Service;

@Service
public interface ListOrganizationUseCase extends BaseUseCase<ListOrganizationPagingRequest, BasePagingResponse<GetOrganizationResponse>> {
}
