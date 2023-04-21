package com.thlogistic.organization.adapters.controllers;

import com.thlogistic.organization.adapters.dtos.*;
import com.thlogistic.organization.core.usecases.CreateOrganizationUseCase;
import com.thlogistic.organization.core.usecases.ListOrganizationUseCase;
import com.thlogistic.organization.core.usecases.UpdateOrganizationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrganizationController extends BaseController implements OrganizationResource {

    private final CreateOrganizationUseCase createOrganizationUseCase;
    private final UpdateOrganizationUseCase updateOrganizationUseCase;
    private final ListOrganizationUseCase listOrganizationUseCase;

    @Override
    public ResponseEntity<Object> listOrganization(ListOrganizationPagingRequest request) {
        BasePagingResponse<GetOrganizationResponse> result = listOrganizationUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> createOrganization(CreateOrganizationRequest request) {
        CreateOrganizationResponse result = createOrganizationUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> updateOrganization(UpdateOrganizationRequest request, String id) {
        updateOrganizationUseCase.execute(Pair.of(id, request));
        return successResponse(true, null);
    }
}
