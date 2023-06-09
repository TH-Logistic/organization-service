package com.thlogistic.organization.adapters.controllers;

import com.thlogistic.organization.adapters.dtos.*;
import com.thlogistic.organization.core.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrganizationController extends BaseController implements OrganizationResource {

    private final GetOrganizationUseCase getOrganizationUseCase;
    private final GetOrganizationDetailUseCase getOrganizationDetailUseCase;
    private final CreateOrganizationUseCase createOrganizationUseCase;
    private final UpdateOrganizationUseCase updateOrganizationUseCase;
    private final ListOrganizationUseCase listOrganizationUseCase;

    @Override
    public ResponseEntity<Object> getOrganization(String id) {
        GetOrganizationResponse result = getOrganizationUseCase.execute(id);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> getOrganizationDetail(String token, String id) {
        GetOrganizationDetailResponse result = getOrganizationDetailUseCase.execute(
                new BaseTokenRequest<>(token, id)
        );
        return successResponse(result, null);
    }

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
