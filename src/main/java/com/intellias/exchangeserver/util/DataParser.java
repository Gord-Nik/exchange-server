package com.intellias.exchangeserver.util;

import java.util.Map;
import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;

public interface DataParser {
    Map<String, Double> parseData(ExchangeRequestDto requestDto);
}
