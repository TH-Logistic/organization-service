package com.thlogistic.organization.adapters.repositories;

import lombok.Data;

@Data
public class BasePagingQueryResult<T> {
    Long total;
    Integer totalPage;
    T data;
}
