package com.thlogistic.organization.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    String id;
    String name;
    String creditCard;
    String contactName;
    String contactNumber;
    OrganizationType type;
    ProviderType providerType;
}
