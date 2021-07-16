package com.intellias.exchangeserver.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

class DataParserJsonTest {
    private static double expected;
    private static double actual;
    private static DataParserJson dataParserJson;
    private static ExchangeRequestDto exchangeRequestDto;

    @BeforeAll
    static void beforeAll() {
        dataParserJson = new DataParserJson();
        exchangeRequestDto = new ExchangeRequestDto();
    }

    @Test
    void parseDataFromJsonWithUahAndUsdParameters_ok() {
        exchangeRequestDto.setBaseCurrency("UAH");
        exchangeRequestDto.setTargetCurrency("USD");
        Map<String, Double> stringDoubleMap = dataParserJson.parseData(exchangeRequestDto);
        actual = stringDoubleMap.get("UAH");
        expected = 27.336594;
        assertEquals(actual, expected);
    }

    @Test
    void parseDataFromJsonWithGbpAndUsdParameters_ok() {
        exchangeRequestDto.setBaseCurrency("GBP");
        exchangeRequestDto.setTargetCurrency("USD");
        Map<String, Double> stringDoubleMap = dataParserJson.parseData(exchangeRequestDto);
        actual = stringDoubleMap.get("GBP");
        expected = 0.740935;
        assertEquals(actual, expected);
    }

    @Test
    void parseDataFromJsonWithCadAndUsdParameters_ok() {
        exchangeRequestDto.setBaseCurrency("CAD");
        exchangeRequestDto.setTargetCurrency("USD");
        Map<String, Double> stringDoubleMap = dataParserJson.parseData(exchangeRequestDto);
        actual = stringDoubleMap.get("CAD");
        expected = 1.360006;
        assertEquals(actual, expected);
    }
}