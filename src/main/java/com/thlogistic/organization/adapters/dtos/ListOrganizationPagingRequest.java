package com.thlogistic.organization.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ListOrganizationPagingRequest extends BasePagingRequest {
    String keyword;
    List<Integer> types;
}
