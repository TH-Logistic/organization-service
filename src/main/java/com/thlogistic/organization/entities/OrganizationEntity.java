package com.thlogistic.organization.entities;

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
}
