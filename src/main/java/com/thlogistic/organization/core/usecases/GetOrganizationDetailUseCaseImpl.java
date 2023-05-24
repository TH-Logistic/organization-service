package com.thlogistic.organization.core.usecases;

import com.thlogistic.organization.adapters.dtos.BaseResponse;
import com.thlogistic.organization.adapters.dtos.BaseTokenRequest;
import com.thlogistic.organization.adapters.dtos.GetOrganizationDetailResponse;
import com.thlogistic.organization.adapters.dtos.GetOrganizationResponse;
import com.thlogistic.organization.aop.exception.CustomRuntimeException;
import com.thlogistic.organization.aop.exception.DataNotFoundException;
import com.thlogistic.organization.client.billing.BillingClient;
import com.thlogistic.organization.client.billing.GetBillingStatisticDto;
import com.thlogistic.organization.core.entities.Organization;
import com.thlogistic.organization.core.ports.OrganizationRepository;
import com.thlogistic.organization.infrastructure.persistence.entities.OrganizationEntity;
import com.thlogistic.organization.mapper.OrganizationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetOrganizationDetailUseCaseImpl implements GetOrganizationDetailUseCase {

    private final GetOrganizationUseCase getOrganizationUseCase;
    private final BillingClient billingClient;

    @Override
    public GetOrganizationDetailResponse execute(BaseTokenRequest<String> baseTokenRequest) {
        String token = baseTokenRequest.getToken();
        String organizationId = baseTokenRequest.getRequestContent();

        GetOrganizationResponse organizationResponse = getOrganizationUseCase.execute(organizationId);

        GetBillingStatisticDto response;
        try {
            response = billingClient.getBillingStatistic(
                    token,
                    organizationId
            ).getData();
        } catch (Exception e) {
            throw new CustomRuntimeException("An error occurred when loading billing statistic");
        }


        return new GetOrganizationDetailResponse(
                organizationResponse,
                response.getProfit(),
                response.getDebt(),
                response.getBillings()
        );
    }
}
