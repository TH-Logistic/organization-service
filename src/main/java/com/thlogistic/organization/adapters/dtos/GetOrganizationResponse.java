package com.thlogistic.organization.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrganizationResponse {
    String id;
    String name;
    String creditCard;
    String contactName;
    String contactNumber;
    Integer type;
    Integer providerType;
}
