package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.Arrays;
import java.util.List;

public class CreateToothpasteCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    private static final String CATEGORY_CREATED = "Toothpaste with name %s was created!";
    private static final String CATEGORY_ALREADY_EXISTS = "Toothpaste with name %s already exists!";

    private final CosmeticsRepository repository;
    public CreateToothpasteCommand(CosmeticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        List<String> ingredients = Arrays.asList(parameters.get(4).split(", "));
        if (repository.productExist(parameters.get(0))) {
            throw new IllegalArgumentException(String.format(CATEGORY_ALREADY_EXISTS, parameters.get(0)));
        }

        repository.createToothpaste(parameters.get(0),
                parameters.get(1),
                ParsingHelpers.tryParseDouble(parameters.get(2), "It's not possible to parse to double."),
                ParsingHelpers.tryParseGender(parameters.get(3)),
                ingredients);
        return String.format(CATEGORY_CREATED, parameters.get(0));
    }

}