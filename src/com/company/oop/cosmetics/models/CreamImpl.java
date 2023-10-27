package com.company.oop.cosmetics.models;
import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class CreamImpl implements Cream {

    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 15;
    public static final String NAME_LENGTH_MESSAGE = "Name should be between 3 and 15 symbols.";
    public static final String BRAND_LENGTH_MESSAGE = "Brand should be between 3 and 15 symbols.";
    private ScentType scent;
    private String name;
    private String brandName;
    private double price;
    private GenderType genderType;


    public CreamImpl(String name, String brandName, double price, GenderType genderType, ScentType scent) {
        setName(name);
        setBrandName(brandName);
        setPrice(price);
        this.genderType = genderType;
        this.scent = scent;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, MIN_LENGTH, MAX_LENGTH, NAME_LENGTH_MESSAGE);
        this.name = name;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        ValidationHelpers.validateStringLength(brandName, MIN_LENGTH, MAX_LENGTH, BRAND_LENGTH_MESSAGE);
        this.brandName = brandName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price should be non negative.");
        }
        this.price = price;
    }

    @Override
    public GenderType getGenderType() {
        return genderType;
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreamImpl cream = (CreamImpl) o;
        return getName().equals(cream.getName()) &&
                getBrandName().equals(cream.getBrandName()) &&
                getPrice() == cream.getPrice() &&
                getGenderType().equals(cream.getGenderType()) &&
                getScent().equals(cream.getScent());
    }

    @Override
    public ScentType getScent() {
        return scent;
    }

    @Override
    public String print() {
        return String.format("#%s %s\n #Price: $%.2f\n #Gender: %s\n #Scent: %s \n",
                getName(), getBrandName(), getPrice(), getGenderType(), getScent());
    }
}
