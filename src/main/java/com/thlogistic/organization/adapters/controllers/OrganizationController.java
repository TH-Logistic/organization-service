package com.thlogistic.organization.adapters.controllers;

import com.thlogistic.organization.adapters.dtos.CreateOrganizationRequest;
import com.thlogistic.organization.adapters.dtos.ListOrganizationPagingRequest;
import com.thlogistic.organization.adapters.dtos.UpdateOrganizationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrganizationController extends BaseController implements OrganizationResource {


    @Override
    public ResponseEntity<Object> listRoute(ListOrganizationPagingRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> createRoute(CreateOrganizationRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateRoute(UpdateOrganizationRequest request, String id) {
        return null;
    }
}
