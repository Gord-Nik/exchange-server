package com.intellias.exchangeserver.model.dto;

import com.intellias.exchangeserver.lib.Currency;
import lombok.Data;

@Data
public class ExchangeRequestDto {
    @Currency
    private String baseCurrency;
    @Currency
    private String targetCurrency;
}
