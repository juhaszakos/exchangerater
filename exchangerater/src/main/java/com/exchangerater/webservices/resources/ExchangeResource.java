package com.exchangerater.webservices.resources;

import com.exchangerater.webscraper.services.WebScraper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("info")
public class ExchangeResource {

    @Inject
    private WebScraper webScraper;

    @GET
    public Response getAllExchangeInfo() throws IOException {
        //URL url = new URL(WebScraper.TMP_CORRECT_CHANGE_URL);
       webScraper.scrapeWebpage();
       return Response.ok().build();
    }
}
