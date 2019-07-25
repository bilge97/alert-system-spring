package guru.springframework.spring5webapp.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring5webapp.controllers.AlertController;
import guru.springframework.spring5webapp.model.Alert;
import guru.springframework.spring5webapp.service.AlertService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml", "classpath:spring/mvc-core-config.xml"})
class AlertControllerTest {

    @Mock
    AlertService alertServiceMock;//alertServiceMock

    @InjectMocks
    AlertController alertController;//alertControllerMock

    MockMvc mockMvc;

    List<Alert> alertList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        alertList.add(new Alert());

        //given(alertService.findAll()).willReturn(alertList);

        mockMvc = MockMvcBuilders.standaloneSetup(alertController).build();
    }


    @Test
    void getAlertTest_Success() throws Exception {

        mockMvc.perform(get("/alerts"))
                .andExpect(status().isOk());
        //.andExpect(model().attributeExists(String.valueOf(alertList)));
        //.andExpect(view().name("alertList"));

    }

    @Test
    void getAlertbyid() throws Exception {
        Alert alert = new Alert();
        alert.setId(1l);

        given(alertServiceMock.findById(1l)).willReturn(alert);

        mockMvc.perform(get("/alert/1"))
                .andExpect(status().isOk());

        then(alertServiceMock).should().findById(1L);
    }

    @Test
    void deleteIdTest() throws Exception {//delete database den
        Alert alert = new Alert();
        alert.setId(1l);
        //voidlere bdd uygulanmıyor

        mockMvc.perform(delete("/alert/1"))
                .andExpect(status().isOk());
    }

    @Test
    void requestParameterTest_isValid() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/alert")
                .param("name", "Bilge")
                .param("url", "http://www.google.com")
                .param("method", "GET")
                .param("period", "5")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void requestParameterTest_nameNull_isNotValid() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/alert")
                        .param("url", "http://www.google.com")
                        .param("method", "GET")
                        .param("period", "5")
                //.contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void requestParameterTest_periodMinSize_isNotValid() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/alert")
                        .param("name","bilge")
                        .param("url", "http://www.google.com")
                        .param("method", "GET")
                        .param("period", "1l")
                //.contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void postAlertReqBodyTest_isValid() throws Exception {

        Alert alert = new Alert();
        alert.setId(1l);
        alert.setName("bilge");
        alert.setUrl("http://www.google.com");
        alert.setMethod("GET");
        alert.setPeriod(5L);

        mockMvc.perform(post("/alert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(AlertControllerTest.objectToString(alert))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void postAlertReqBodyTest_periodMinSize_isNotValid() throws Exception {

        Alert alert = new Alert();
        alert.setId(1l);
        alert.setName("bilge");
        alert.setUrl("http://www.google.com");
        alert.setMethod("GET");
        alert.setPeriod(1L);//min 2

        mockMvc.perform(post("/alert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(AlertControllerTest.objectToString(alert)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void postAlertReqBodyTest_method_isNotValid() throws Exception {

        Alert alert = new Alert();
        alert.setId(1l);
        alert.setName("bilge");
        alert.setUrl("http://www.google.com");
        //method null
        alert.setPeriod(3l);

        mockMvc.perform(post("/alert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(AlertControllerTest.objectToString(alert)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    void putAlertTest() throws Exception{

        Alert alert = new Alert("bigo" , "http://www.google.com" , "GET" , 5l);
        when(alertServiceMock.findById(alert.getId())).thenReturn(alert);
        doNothing().when(alertServiceMock).save(alert);
        mockMvc.perform(
                put("/alert/{id}",alert.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(AlertControllerTest.objectToString(alert)))
                .andExpect(status().isOk());
        verify(alertServiceMock).findById(alert.getId());
        verify(alertServiceMock).save(alert);

    }

    //toString function
    public static String objectToString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}