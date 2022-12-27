package com.exchangerater.webscraper.services;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class WebScraper {

    // TODO akos 2022-12-23: drop this
    public static final String TMP_CORRECT_CHANGE_URL = "https://correctchange.hu/";
    public static final String TMP_KORONA_CHANGE_URL = "http://www.koronachange.hu/";
    private static final String XPATH_FOR_ALL_TABLES = "//table";
    // TODO akos 2022.12.27: drop it private static final String XPATH_FOR_ROWS_IN_TBODY = "./tbody/tr";

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private WebClient webClient;

    public void scrapeWebpage() {
        Arrays.asList(TMP_CORRECT_CHANGE_URL, TMP_KORONA_CHANGE_URL).stream()
                .forEach(url -> {
                    HtmlPage page = null;
                    try {
                        page = webClient.getPage(url);
                    } catch (IOException e) {
                        // TODO akos 2022.12.27: create dedicated exception
                        throw new RuntimeException(e);
                    }
                    List<HtmlElement> tableList = page.getByXPath(XPATH_FOR_ALL_TABLES);
                    tableList.forEach(table -> logger.info(table.asNormalizedText()));
                });
    }
}
