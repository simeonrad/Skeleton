package com.company.oop.cosmetics.models;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;
import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductCosm implements Toothpaste, Product {

    private List<String> ingredients;

    public ToothpasteImpl(String name, String brandName, double price, GenderType genderType, List<String> ingredients) {
        super(name, brandName, price, genderType);
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    @Override
    public String print() {
        StringBuilder ingredientsPrint = new StringBuilder();
        for (String ingredient:ingredients) {
            ingredientsPrint.append(ingredient);
        }
        return String.format("#%s %s\n #Price: %.2f\n #Gender: %s\n #Ingredients: [%s]\n",
                getName(), getBrandName(), getPrice(), getGenderType(), ingredientsPrint);
    }
}