package com.thlogistic.organization.core.usecases;

public interface BaseUseCase<Request, Response> {
    Response execute(Request request);
}
