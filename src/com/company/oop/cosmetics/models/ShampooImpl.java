package com.company.oop.cosmetics.models;
import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;

public class ShampooImpl extends ProductCosm implements Shampoo {
    private final String MILLILITERS_ERROR_MESSAGE = "Milliliters should be non negative.";
    private int milliliters;
    private UsageType usageType;

    public ShampooImpl(String name, String brandName, double price, GenderType genderType, int milliliters, UsageType usageType) {
        super(name, brandName, price, genderType);
        setMilliliters(milliliters);
        this.usageType = usageType;
    }

    //---------------------------------------------------------------

    @Override
    public int getMillilitres() {
        return milliliters;
    }

    public void setMilliliters(int milliliters) {
        if (milliliters < 0) {
            throw new IllegalArgumentException(MILLILITERS_ERROR_MESSAGE);
        }
        this.milliliters = milliliters;
    }

    //---------------------------------------------------------------

    @Override
    public UsageType getUsageType() {
        return usageType;
    }

    //---------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShampooImpl shampoo = (ShampooImpl) o;
        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }


//
    @Override
    public String print() {
        return String.format("#%s %s\n #Price: $%.2f\n #Gender: %s\n #Milliliters: %d\n #Usage: %s\n",
                getName(), getBrandName(), getPrice(), getGenderType(), getMillilitres(), getUsageType());
    }
}
