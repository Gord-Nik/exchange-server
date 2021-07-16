package com.intellias.exchangeserver.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;
import com.intellias.exchangeserver.model.dto.ExchangeResponseDto;
import com.intellias.exchangeserver.util.DataParser;
import com.intellias.exchangeserver.util.DataParserJson;
import org.junit.jupiter.api.Test;;
import org.junit.jupiter.api.BeforeEach;

class ExchangeServiceImplTest {
    private static ExchangeRequestDto exchangeRequestDto;
    private static ExchangeResponseDto exchangeResponseDto;
    private final DataParser dataParser = new DataParserJson();
    private final CurrencyExchanger currencyExchanger = new CurrencyExchanger();
    private final ExchangeService exchangeService = new ExchangeServiceImpl(dataParser, currencyExchanger);


    @BeforeEach
    void beforeEach() {
        exchangeRequestDto = new ExchangeRequestDto();
        exchangeResponseDto = new ExchangeResponseDto();
    }

    @Test
    void getExchangeResponseDtoTestWithUahAndUsdParameters_ok() {
        exchangeRequestDto.setBaseCurrency("UAH");
        exchangeRequestDto.setTargetCurrency("USD");
        ExchangeResponseDto exchangeResponseDto = exchangeService.getExchangeResponseDto(exchangeRequestDto);
        String actual = exchangeResponseDto.getExchangeRate();
        String expected = String.valueOf(0.03658100200778487);
        assertEquals(actual, expected);
    }

    @Test
    void getExchangeResponseDtoTestWithUahAndEurParameters_ok() {
        exchangeRequestDto.setBaseCurrency("UAH");
        exchangeRequestDto.setTargetCurrency("EUR");
        ExchangeResponseDto exchangeResponseDto = exchangeService.getExchangeResponseDto(exchangeRequestDto);
        String actual = exchangeResponseDto.getExchangeRate();
        String expected = String.valueOf(0.029861291424966838);
        assertEquals(actual, expected);
    }

    @Test
    void getExchangeResponseDtoTestWithGbpAndCadParameters_ok() {
        exchangeRequestDto.setBaseCurrency("GBP");
        exchangeRequestDto.setTargetCurrency("CAD");
        ExchangeResponseDto exchangeResponseDto = exchangeService.getExchangeResponseDto(exchangeRequestDto);
        String actual = exchangeResponseDto.getExchangeRate();
        String expected = String.valueOf(1.8355267331142409);
        assertEquals(actual, expected);
    }

}