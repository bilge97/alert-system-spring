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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Configuration
@EnableAsync
@EnableScheduling
@Service
public class TimeService {

    static int responseCode;
    static String responseMessage;

    private static AlertService alertService;
    private static AlertRepository alertRepository;
    private static ResponseRepository responseRepository;
    private static AsynchService asynchService;

    private static int per=0;

    @Autowired
    public TimeService(AlertService alertService , AsynchService asynchService ,AlertRepository alertRepository) {

        this.alertService = alertService;
        this.asynchService = asynchService;
        this.alertRepository = alertRepository;

    }


    @Scheduled(fixedDelay = 1000)
    public  void periodCycle() throws IOException {

        per += 1;
        System.out.println(per);
        List<Alert> Arr = alertService.findAll();

        //System.out.println(Arr);

        for (Alert item: Arr) {

            System.out.println(item.getName()+" girdi");

            if(per%item.getPeriod() == 0)
            {
                asynchService.getConnection(item);
            }

            System.out.println(item.getName()+" cıktı");

        }


    }





}
