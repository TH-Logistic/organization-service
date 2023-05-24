package com.thlogistic.organization.client.billing;

import com.thlogistic.organization.adapters.dtos.BaseResponse;
import com.thlogistic.organization.client.auth.PermissionDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BillingClient {
    @RequestLine("GET /api/v1/billing/statistic/organization/{organizationId}")
    @Headers({
            "Content-Type: application/json",
            "Authorization: {token}"
    })
    BaseResponse<GetBillingStatisticDto> getBillingStatistic(@Param("token") String token, @Param("id") String organizationId);
}
