package guru.springframework.spring5webapp.Model;


import guru.springframework.spring5webapp.model.Alert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class AlertTest {

    @Test
    void getIdTest() {
        Alert alert = new Alert();
        alert.setId(1L);
        assertTrue(alert.getId()==1l);
    }

    @Test
    void setIdTest() {
        Alert alert = new Alert();
        alert.setId(1l);
        assertTrue(alert.getId()==1l);
    }

    @Test
    void getNameTest() {
        Alert alert = new Alert();
        alert.setName("Bilge");
        assertTrue(alert.getName()=="Bilge");
    }

    @Test
    void setNameTest() {
        Alert alert = new Alert();
        alert.setName("Bilge");
        assertTrue(alert.getName()=="Bilge");
    }

    @Test
    void getUrlTest() {
        Alert alert = new Alert();
        alert.setUrl("http://www.google.com");
        assertTrue(alert.getUrl() == "http://www.google.com");
    }

    @Test
    void setUrlTest() {
        Alert alert = new Alert();
        alert.setUrl("http://www.google.com");
        assertTrue(alert.getUrl() == "http://www.google.com");
    }

    @Test
    void getMethodTest() {
        Alert alert = new Alert();
        alert.setMethod("GET");
        assertTrue(alert.getMethod() == "GET");
    }

    @Test
    void setMethodTest() {
        Alert alert = new Alert();
        alert.setMethod("GET");
        assertTrue(alert.getMethod() == "GET");
    }

    @Test
    void getPeriodTest() {
        Alert alert = new Alert();
        alert.setPeriod((long) 5);
        assertTrue(alert.getPeriod() == (long)5);
    }

    @Test
    void setPeriodTest() {
        Alert alert = new Alert();
        alert.setPeriod((long) 5);
        assertTrue(alert.getPeriod() == (long)5);
    }

    @DisplayName("Value source test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")//deneme
    @ValueSource(strings = {"Spring1" , "Spring2" , "Spring3"})
    void testValueSource(String val)
    {
        System.out.println(val);
    }
}
