package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public abstract class ProductCosm implements Product {

    private static final String PRICE_MESSAGE_ERROR = "Price should be non negative.";
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_NAME_MIN_LENGTH = 2;
    private static final int BRAND_NAME_MAX_LENGTH = 10;
    public static final String NAME_MESSAGE_LENGTH_ERROR = "Name should be between 3 and 10 symbols.";
    public static final String BRAND_NAME_LENGTH_ERROR = "Brand should be between 2 and 10 symbols.";
    private String name;
    private String brandName;
    private double price;
    private GenderType genderType;

    public ProductCosm(String name, String brandName, double price, GenderType genderType) {
        setName(name);
        setBrandName(brandName);
        setPrice(price);
        this.genderType = genderType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, NAME_MESSAGE_LENGTH_ERROR);
        this.name = name;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        ValidationHelpers.validateStringLength(brandName, BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH, BRAND_NAME_LENGTH_ERROR);
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(PRICE_MESSAGE_ERROR);
        }
        this.price = price;
    }

    public GenderType getGenderType() {
        return genderType;
    }
}