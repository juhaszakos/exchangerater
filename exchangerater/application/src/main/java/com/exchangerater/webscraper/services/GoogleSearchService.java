package com.exchangerater.webscraper.services;

import com.exchangerater.webscraper.utils.ReadSystemVariables;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ApplicationScoped
public class GoogleSearchService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private static final String API_KEY = "apiKey";
    private static final String CX_KEY = "cxKey";
    private static final String SEARCH_KEY = "searchKey";
    private static final String GOOGLE_SRCH_URL_TEMPLATE = "https://www.googleapis.com/customsearch/v1?key=" +
            "{" + API_KEY+ "}" +
            "&cx={" + CX_KEY + "}" +
            "&q={" + SEARCH_KEY + "}";

    public void getExchangeUrls(String searchKey) {
        Map<String, String> googleSrchParameters = new HashMap<>();
        googleSrchParameters.put(API_KEY, ReadSystemVariables.getGoogleSrchApiKey());
        googleSrchParameters.put(CX_KEY, ReadSystemVariables.getGoogleSrchCxKey());
        googleSrchParameters.put(SEARCH_KEY, searchKey);

        Client client = ClientBuilder.newClient();
        URI googleSrchUri = UriBuilder.fromUri(GOOGLE_SRCH_URL_TEMPLATE).buildFromMap(googleSrchParameters);
        WebTarget target = client.target(googleSrchUri);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        String responseJsonString = response.readEntity(String.class);
        logger.info(responseJsonString);
    }
}
