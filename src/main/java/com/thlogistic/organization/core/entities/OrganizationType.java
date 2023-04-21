package com.thlogistic.organization.core.entities;


import com.thlogistic.organization.aop.exception.InvalidOrganizationTypeException;

public enum OrganizationType {
    CUSTOMER(1),
    PARTNER(2),
    PROVIDER(3);

    public final Integer typeCode;

    OrganizationType(Integer code) {
        typeCode = code;
    }

    public static OrganizationType fromInt(Integer value) {
        for (OrganizationType type: values()) {
            if (type.typeCode.equals(value)) {
                return type;
            }
        }
        throw new InvalidOrganizationTypeException("Organization type not found");
    }

}
