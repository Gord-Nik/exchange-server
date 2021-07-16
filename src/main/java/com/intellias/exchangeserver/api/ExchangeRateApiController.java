package com.intellias.exchangeserver.api;

import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;
import com.intellias.exchangeserver.model.dto.ExchangeResponseDto;
import com.intellias.exchangeserver.service.ExchangeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/exchange")
public class ExchangeRateApiController {
    private final ExchangeService exchangeService;

    public ExchangeRateApiController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping
    public ExchangeResponseDto exchange(@RequestBody @Valid ExchangeRequestDto requestDto) {
         return exchangeService.getExchangeResponseDto(requestDto);
    }
}
