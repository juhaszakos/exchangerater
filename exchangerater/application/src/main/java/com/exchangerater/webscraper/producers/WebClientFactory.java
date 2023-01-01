package com.exchangerater.webscraper.producers;

import com.gargoylesoftware.htmlunit.WebClient;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

public class WebClientFactory {

    @Produces
    @Dependent
    WebClient getWebClient() {
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        return webClient;
    }
}
