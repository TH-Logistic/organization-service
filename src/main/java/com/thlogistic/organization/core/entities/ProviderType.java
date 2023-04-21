package com.thlogistic.organization.core.entities;


import com.thlogistic.organization.aop.exception.InvalidOrganizationTypeException;
import com.thlogistic.organization.aop.exception.InvalidProviderTypeException;

public enum ProviderType {
    FUEL(1),
    REPAIR(2),
    REPLACE(3);

    public final Integer typeCode;

    ProviderType(Integer code) {
        typeCode = code;
    }

    public static ProviderType fromInt(Integer value) {
        for (ProviderType type: values()) {
            if (type.typeCode.equals(value)) {
                return type;
            }
        }
        throw new InvalidProviderTypeException("Provider type not found");
    }

}
