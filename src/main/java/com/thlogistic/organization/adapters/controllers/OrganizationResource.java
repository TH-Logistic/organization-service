package com.thlogistic.organization.adapters.controllers;

import com.thlogistic.organization.adapters.dtos.CreateOrganizationRequest;
import com.thlogistic.organization.adapters.dtos.ListOrganizationPagingRequest;
import com.thlogistic.organization.adapters.dtos.UpdateOrganizationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/organization")
interface OrganizationResource {
    @GetMapping("/{id}")
    ResponseEntity<Object> getOrganization(@PathVariable String id);

    @GetMapping("/detail/{id}")
    ResponseEntity<Object> getOrganizationDetail(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable String id);

    @GetMapping("/list")
    ResponseEntity<Object> listOrganization(@Valid ListOrganizationPagingRequest request);

    @PostMapping
    ResponseEntity<Object> createOrganization(@Valid @RequestBody CreateOrganizationRequest request);

    @PutMapping("/{id}")
    ResponseEntity<Object> updateOrganization(@Valid @RequestBody UpdateOrganizationRequest request, @PathVariable String id);
}
