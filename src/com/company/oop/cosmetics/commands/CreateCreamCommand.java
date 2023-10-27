package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateCreamCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    private static final String CREAM_CREATED = "Cream with name %s was created!";
    private static final String CREAM_ALREADY_EXISTS = "Cream with name %s already exists!";

    private final CosmeticsRepository repository;

    public CreateCreamCommand(CosmeticsRepository cosmeticsRepository) {
        this.repository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        if (repository.productExist(parameters.get(0))) {
            throw new IllegalArgumentException(String.format(CREAM_ALREADY_EXISTS, parameters.get(0)));
        }
        repository.createCream(parameters.get(0), parameters.get(1),
                ParsingHelpers.tryParseDouble(parameters.get(2), "It's not possible to parse to double."),
                ParsingHelpers.tryParseGender(parameters.get(3)),
                ParsingHelpers.tryParseScent(parameters.get(4)));
        return String.format(CREAM_CREATED, parameters.get(0));
    }
}
