package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.model.Alert;
import guru.springframework.spring5webapp.model.Response;
import guru.springframework.spring5webapp.repository.AlertRepository;
import guru.springframework.spring5webapp.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Configuration
@EnableAsync
@EnableScheduling
@Service
public class AsynchService {

    static int responseCode;
    static String responseMessage;

    private static AlertService alertService;
    private static AlertRepository alertRepository;
    private static ResponseRepository responseRepository;

    @Autowired
    public AsynchService(AlertService alertService , AlertRepository alertRepository) {

        this.alertService = alertService;
        this.alertRepository = alertRepository;

    }

    @Async
    public void getConnection(Alert item) throws IOException {


        URL url = new URL(item.getUrl());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(item.getMethod());
        responseCode = con.getResponseCode();
        Response response = new Response();
        response.setResponsecode(responseCode);

        item.getResponse().add(response);
        alertService.save(item);


        System.out.println(item.getName() +" responseCode " + responseCode);



    }


}
