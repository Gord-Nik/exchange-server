package com.intellias.exchangeserver.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConstraintValidator implements ConstraintValidator<Currency, String> {
    @Override
    public void initialize(Currency constraintAnnotation) {
    }

    @Override
    public boolean isValid(String currencyField, ConstraintValidatorContext constraintValidatorContext) {
        List<String> stringList = new ArrayList<>();
        stringList.add("USD");
        stringList.add("UAH");
        stringList.add("GBP");
        stringList.add("EUR");
        stringList.add("CAD");
        return stringList.contains(currencyField);
    }
}
