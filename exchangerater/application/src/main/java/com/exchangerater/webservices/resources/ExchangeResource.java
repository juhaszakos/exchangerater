package com.exchangerater.webservices.resources;

import com.exchangerater.persistence.daos.ExchangeWebResourceDao;
import com.exchangerater.webscraper.dtos.ExchangeRateDto;
import com.exchangerater.webscraper.services.GoogleSearchService;
import com.exchangerater.webscraper.services.WebScraperService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("info")
public class ExchangeResource {

    @Inject
    private WebScraperService webScraperService;
    @Inject
    private GoogleSearchService googleSearchService;

    @EJB
    private ExchangeWebResourceDao exchangeWebResourceEntityBaseDao;

    @GET
    public Response getAllExchangeInfo() throws IOException {
        //URL url = new URL(WebScraper.TMP_CORRECT_CHANGE_URL);
        ExchangeRateDto.builder().build();
       webScraperService.scrapeWebpage();
       googleSearchService.getExchangeUrls("exchange in budapest");
       return Response.ok().build();
    }
}
