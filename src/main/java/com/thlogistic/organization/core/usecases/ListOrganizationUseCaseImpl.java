package com.thlogistic.organization.core.usecases;

import com.thlogistic.organization.adapters.dtos.BasePagingResponse;
import com.thlogistic.organization.adapters.dtos.GetOrganizationResponse;
import com.thlogistic.organization.adapters.dtos.ListOrganizationPagingRequest;
import com.thlogistic.organization.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.organization.core.ports.OrganizationRepository;
import com.thlogistic.organization.infrastructure.persistence.entities.OrganizationEntity;
import com.thlogistic.organization.mapper.OrganizationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOrganizationUseCaseImpl implements ListOrganizationUseCase {

    private final OrganizationRepository repository;

    @Override
    public BasePagingResponse<GetOrganizationResponse> execute(ListOrganizationPagingRequest request) {
        BasePagingQueryResult<List<OrganizationEntity>> queryResult;
        if (request.getTypes() != null && !request.getTypes().isEmpty()) {
            queryResult = repository.listWithTypes(request.getKeyword(),
                    request.getTypes(),
                    request.getPage(),
                    request.getSize());
        } else {
            queryResult = repository.list(request.getKeyword(),
                    request.getPage(),
                    request.getSize());
        }

        BasePagingResponse<GetOrganizationResponse> response = new BasePagingResponse<>();
        response.setContent(queryResult.getData().stream().map(e ->
                OrganizationMapper.fromOrganizationToResponse(e.toOrganization())).toList()
        );
        response.setTotal(queryResult.getTotal());
        response.setTotalPage(queryResult.getTotalPage());
        return response;
    }
}
