package com.thlogistic.organization.adapters.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrganizationRequest {
    @NotBlank(message = "Invalid name")
    String name;
    @NotBlank(message = "Invalid credit card")
    String creditCard;
    @NotBlank(message = "Invalid contact name")
    String contactName;
    @NotBlank(message = "Invalid contact number")
    String contactNumber;
    @NotNull(message = "Invalid type")
    Integer type;
    Integer providerType;
}
