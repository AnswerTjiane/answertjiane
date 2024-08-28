package com.assignment.senior001.answertjiane.dto;

public enum EmissionSource {
    TRANSPORTATION,
    ENERGY,
    OTHER;

    public static boolean isValidEmissionSource(String source) {
        for (EmissionSource emissionSource : EmissionSource.values()) {
            if (emissionSource.name().equalsIgnoreCase(source)) {
                return true;
            }
        }
        return false;
    }
}
