package com.thlogistic.organization.mapper;


import com.thlogistic.organization.adapters.dtos.GetOrganizationResponse;
import com.thlogistic.organization.core.entities.Organization;

public class OrganizationMapper {
    public static GetOrganizationResponse fromOrganizationToResponse(Organization organization) {
        GetOrganizationResponse response = new GetOrganizationResponse();
        response.setId(organization.getId());
        response.setName(organization.getName());
        response.setCreditCard(organization.getCreditCard());
        response.setContactName(organization.getContactName());
        response.setContactNumber(organization.getContactNumber());
        response.setType(organization.getType().typeCode);
        if (organization.getProviderType() != null) {
            response.setProviderType(organization.getProviderType().typeCode);
        }
        else {
            response.setProviderType(null);
        }
        return response;
    }
}
