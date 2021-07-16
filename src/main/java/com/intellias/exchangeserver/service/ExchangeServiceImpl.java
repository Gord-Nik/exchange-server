package com.intellias.exchangeserver.service;

import java.util.Map;
import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;
import com.intellias.exchangeserver.model.dto.ExchangeResponseDto;
import com.intellias.exchangeserver.util.DataParser;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    private final DataParser dataParser;
    private final CurrencyExchanger currencyExchanger;

    public ExchangeServiceImpl(DataParser dataParser, CurrencyExchanger currencyExchanger) {
        this.dataParser = dataParser;
        this.currencyExchanger = currencyExchanger;
    }

    @Override
    public ExchangeResponseDto getExchangeResponseDto(ExchangeRequestDto requestDto) {
        ExchangeResponseDto exchangeResponseDto = new ExchangeResponseDto();
        Map<String, Double> currencyMap = dataParser.parseData(requestDto);
        Double exchange = currencyExchanger.exchange(currencyMap, requestDto);
        exchangeResponseDto.setExchangeRate(exchange.toString());
        return exchangeResponseDto;
    }
}
