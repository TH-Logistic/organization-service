package com.thlogistic.organization.adapters.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BasePagingResponse<T> {
    Long total;
    Integer totalPage;
    List<T> content;
}
