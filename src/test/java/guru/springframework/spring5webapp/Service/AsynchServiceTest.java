package guru.springframework.spring5webapp.Service;

import guru.springframework.spring5webapp.model.Alert;
import guru.springframework.spring5webapp.model.Response;
import guru.springframework.spring5webapp.service.AsynchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.postgresql.util.ReaderInputStream;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.net.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AsynchServiceTest {

    @Autowired
    AsynchService asynchService;

    @Mock
    HttpURLConnection mockHttpConnection;

    Set<Response> responseSet;


    @Test
    void getConnectionTest() throws IOException {


/*
        Alert alert = new Alert();
        alert.setUrl("http://www.google.com");
        int expected = 200;
        Assertions.assertEquals(asynchService.func(alert) , expected);
 */
        Response response = new Response();
        Alert alert = new Alert();

        alert.setId(1l);
        alert.setName("bilge");
        alert.setUrl("http://www.google.com");
        alert.setMethod("GET");
        alert.setPeriod(1l);
        // alert.setResponseSet(responseSet);


        // asynchService.func(alert);

        int expected = 200 ;

        asynchService.getConnection(alert);

        System.out.println(alert.getName());


        // Assertions.assertEquals(expected , response.getResponsecode() );


    }
}