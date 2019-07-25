package guru.springframework.spring5webapp.Model;

import guru.springframework.spring5webapp.model.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void getResp_id() {
        Response response = new Response();
        response.setResp_id(1l);
        assertTrue(response.getResp_id() == 1l);
    }

    @Test
    void setResp_id() {
        Response response = new Response();
        response.setResp_id(1l);
        assertTrue(response.getResp_id() == 1l);
    }

    @Test
    void getId() {
        Response response = new Response();
        response.setId(1l);
        assertTrue(response.getId() == 1l);
    }

    @Test
    void setId() {
        Response response = new Response();
        response.setId(1l);
        assertTrue(response.getId() == 1l);
    }

    @Test
    void getResponsecode() {
        Response response = new Response();
        response.setResponsecode(200);
        assertTrue(response.getResponsecode() == 200);
    }

    @Test
    void setResponsecode() {
        Response response = new Response();
        response.setResponsecode(200);
        assertTrue(response.getResponsecode() == 200);
    }
}