package com.intellias.exchangeserver.service;

import java.util.Map;
import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchanger {
    private static final String BASE_CURRENCY_FOR_JSON_FILE = "USD";
    private static final int BASE_VALUE_FOR_BASE_CURRENCY = 1;

    public Double exchange(Map<String, Double> currencyMap, ExchangeRequestDto requestDto) {
        double ResultMathOperationsWithCurrencyRates;

        Double baseCurrencyExchangeRate = currencyMap.get(requestDto.getBaseCurrency());
        Double targetCurrencyExchangeRate = currencyMap.get(requestDto.getTargetCurrency());

        String baseCurrencyName = requestDto.getBaseCurrency();
        String targetCurrencyName = requestDto.getTargetCurrency();

        if (baseCurrencyName.equals(BASE_CURRENCY_FOR_JSON_FILE)) {
            return targetCurrencyExchangeRate;
        } if (targetCurrencyName.equals(BASE_CURRENCY_FOR_JSON_FILE)) {
            ResultMathOperationsWithCurrencyRates = BASE_VALUE_FOR_BASE_CURRENCY / baseCurrencyExchangeRate;
            return ResultMathOperationsWithCurrencyRates;
        } else {
            ResultMathOperationsWithCurrencyRates = targetCurrencyExchangeRate / baseCurrencyExchangeRate;
            return ResultMathOperationsWithCurrencyRates;
        }
    }
}
