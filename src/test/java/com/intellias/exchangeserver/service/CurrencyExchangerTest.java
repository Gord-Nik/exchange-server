package com.intellias.exchangeserver.service;

import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;
import com.intellias.exchangeserver.util.DataParserJson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyExchangerTest {
    private static final String UAH = "UAH";
    private static final String USD = "USD";
    private static final String CAD = "CAD";
    private static final String EUR = "EUR";
    private static final String GBP = "GBP";
    private static final double USD_TO_UAH_RATE = 27.336594;
    private static final double USD_TO_CAD_RATE = 1.360006;
    private static final double USD_TO_EUR_RATE = 0.816306;
    private static final double USD_TO_GBP_RATE = 0.740935;
    private static double expected;
    private static double actual;
    private static CurrencyExchanger currencyExchanger;
    private static ExchangeRequestDto exchangeRequestDto;
    private static Map<String, Double> currencyMap;

    @BeforeAll
    static void beforeAll() {
        currencyExchanger = new CurrencyExchanger();
        exchangeRequestDto = new ExchangeRequestDto();
    }

    @BeforeEach
    void beforeEach() {
        currencyMap = new HashMap<>();
    }

    @Test
    void exchangeUAHtoUSD_Ok() {
        exchangeRequestDto.setBaseCurrency("UAH");
        exchangeRequestDto.setTargetCurrency("USD");
        currencyMap.put(UAH, USD_TO_UAH_RATE);
        currencyMap.put(USD, null);
        actual = currencyExchanger.exchange(currencyMap, exchangeRequestDto);
        expected = 0.03658100200778487;
        assertEquals(actual,expected);
    }

    @Test
    void exchangeUSDtoUAH_Ok() {
        exchangeRequestDto.setBaseCurrency("USD");
        exchangeRequestDto.setTargetCurrency("UAH");
        currencyMap.put(UAH, USD_TO_UAH_RATE);
        currencyMap.put(USD, null);
        actual = currencyExchanger.exchange(currencyMap, exchangeRequestDto);
        expected = 27.336594;
        assertEquals(actual,expected);
    }

    @Test
    void exchangeUAHtoEUR_Ok() {
        exchangeRequestDto.setBaseCurrency("UAH");
        exchangeRequestDto.setTargetCurrency("EUR");
        currencyMap.put(UAH, USD_TO_UAH_RATE);
        currencyMap.put(EUR, USD_TO_EUR_RATE);
        actual = currencyExchanger.exchange(currencyMap, exchangeRequestDto);
        expected = 0.029861291424966838;
        assertEquals(actual,expected);
    }

    @Test
    void exchangeUAHtoCAD_Ok() {
        exchangeRequestDto.setBaseCurrency("UAH");
        exchangeRequestDto.setTargetCurrency("CAD");
        currencyMap.put(UAH, USD_TO_UAH_RATE);
        currencyMap.put(CAD, USD_TO_CAD_RATE);
        actual = currencyExchanger.exchange(currencyMap, exchangeRequestDto);
        expected = 0.04975038221659948;
        assertEquals(actual,expected);
    }

    @Test
    void exchangeGBPtoCAD_Ok() {
        exchangeRequestDto.setBaseCurrency("GBP");
        exchangeRequestDto.setTargetCurrency("CAD");
        currencyMap.put(GBP, USD_TO_GBP_RATE);
        currencyMap.put(CAD, USD_TO_CAD_RATE);
        actual = currencyExchanger.exchange(currencyMap, exchangeRequestDto);
        expected = 1.8355267331142409;
        assertEquals(actual,expected);
    }

}