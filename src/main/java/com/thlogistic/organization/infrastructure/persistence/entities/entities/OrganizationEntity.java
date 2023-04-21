package com.thlogistic.organization.infrastructure.persistence.entities.entities;

import com.thlogistic.organization.core.entities.Organization;
import com.thlogistic.organization.core.entities.OrganizationType;
import com.thlogistic.organization.core.entities.ProviderType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("organization")
public class OrganizationEntity {
    @Id
    String id;
    String name;
    String creditCard;
    String contactName;
    String contactNumber;
    OrganizationType type;
    ProviderType providerType;

    public OrganizationEntity(String creditCard, String name, String contactName, String contactNumber, OrganizationType type, ProviderType providerType) {
        this.creditCard = creditCard;
        this.name = name;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.type = type;
        this.providerType = providerType;
    }

    public Organization toOrganization() {
        return new Organization(
                this.id,
                this.name,
                this.creditCard,
                this.contactName,
                this.contactNumber,
                this.type,
                this.providerType);
    }
}
