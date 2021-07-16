package com.intellias.exchangeserver.service;

import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;
import com.intellias.exchangeserver.model.dto.ExchangeResponseDto;

public interface ExchangeService {
    ExchangeResponseDto getExchangeResponseDto(ExchangeRequestDto requestDto);
}
