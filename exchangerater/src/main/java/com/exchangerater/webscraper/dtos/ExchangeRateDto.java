package com.exchangerater.webscraper.dtos;

import com.exchangerater.webscraper.utils.Currency;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ExchangeRateDto {
    private Currency currency;
    private Long buy;
    private Long sell;
}
