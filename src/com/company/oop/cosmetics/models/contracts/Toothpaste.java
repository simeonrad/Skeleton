package com.company.oop.cosmetics.models.contracts;

import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.List;

public interface Toothpaste {

    List<String> getIngredients();

    String getBrandName();

    double getPrice();

    GenderType getGenderType();

    String getName();
}
