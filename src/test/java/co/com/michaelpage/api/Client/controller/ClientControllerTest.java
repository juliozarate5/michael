package co.com.michaelpage.api.Client.controller;

import co.com.michaelpage.api.Client.ClientApplication;
import co.com.michaelpage.api.Client.dto.ClientDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Julio Martínez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientControllerTest {


    @LocalServerPort
    private int port;

    private static final TestRestTemplate REST_TEMPLATE = new TestRestTemplate();
    private final static String URL_CLIENTES = "/client";

    private String createURLWithPort(String uri) {
        return "http://localhost:"
                .concat(String.valueOf(port)).concat("/api/v1").concat(uri);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = REST_TEMPLATE.exchange(
                createURLWithPort(URL_CLIENTES),
                HttpMethod.GET, entity, String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void create(){
        ClientDto cl = new ClientDto();
        cl.setFirstName("Julio");
        cl.setLastName("Martinez");
        cl.setEmail("email@email.com");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ClientDto> entity = new HttpEntity<>(cl, headers);

        ResponseEntity<String> response = REST_TEMPLATE.exchange(
                createURLWithPort(URL_CLIENTES),
                HttpMethod.POST, entity, String.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}