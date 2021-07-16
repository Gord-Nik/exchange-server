package com.intellias.exchangeserver.util;

import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;

import java.util.Map;

public interface DataParser {
    Map<String, Double> parseData(ExchangeRequestDto requestDto);
}
