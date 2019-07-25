package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.model.Alert;
import guru.springframework.spring5webapp.model.Response;
import guru.springframework.spring5webapp.repository.AlertRepository;
import guru.springframework.spring5webapp.repository.ResponseRepository;
import guru.springframework.spring5webapp.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class Spring5webappApplication  {

	static int responseCode;
	static String responseMessage;

	private static AlertService alertService;
	private static AlertRepository alertRepository;
	private static ResponseRepository responseRepository;



	@Autowired
	public Spring5webappApplication(AlertService alertService , ResponseRepository responseRepository) {
		this.alertService = alertService;
		this.responseRepository = responseRepository;
	}



	public static void main(String[] args) throws Exception {



		SpringApplication.run(Spring5webappApplication.class, args);


	}




}
