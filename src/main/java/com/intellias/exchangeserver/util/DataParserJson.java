package com.intellias.exchangeserver.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.intellias.exchangeserver.model.dto.ExchangeRequestDto;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class DataParserJson implements DataParser {
    public Map<String, Double> parseData(ExchangeRequestDto requestDto) {
        try (FileReader fileReader = new FileReader("src/main/resources/rates/data.json")) {
            Object object = new JSONParser().parse(fileReader);
            JSONObject jo = (JSONObject) object;
            JSONObject rates = (JSONObject) jo.get("rates");

            String baseCurrencyName = requestDto.getBaseCurrency();
            Double baseCurrencyRate = (Double) rates.get(requestDto.getBaseCurrency());

            String targetCurrencyName = requestDto.getTargetCurrency();
            Double targetCurrencyRate = (Double) rates.get(requestDto.getTargetCurrency());

            Map<String, Double> currencyMap = new HashMap<>();
            currencyMap.put(baseCurrencyName, baseCurrencyRate);
            currencyMap.put(targetCurrencyName, targetCurrencyRate);
            return currencyMap;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!");
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Parse exception!");
        }
    }
}
