package com.thlogistic.organization.adapters.dtos;

import com.thlogistic.organization.client.billing.BillingStatisticOverviewDto;
import com.thlogistic.organization.client.billing.GetBillingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrganizationDetailResponse {
    GetOrganizationResponse organization;
    BillingStatisticOverviewDto profit;
    BillingStatisticOverviewDto debt;
    List<GetBillingDto> billings;
}
