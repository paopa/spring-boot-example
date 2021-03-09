package simple;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;
import per.pao.example.Application;
import per.pao.example.dao.jpa.SimpleRepository;
import per.pao.example.entity.SimpleDo;

import java.util.Collections;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleControllerTests {

    @Autowired
    private SimpleRepository simpleRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetSimpleDos() {
        SimpleDo simpleDo =
                new SimpleDo();
        simpleDo.setName("david_real");
        simpleDo.setAge(25);
        simpleRepository.save(simpleDo);
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api/v1/simple");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = testRestTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        assertTrue("testGetSimpleDos Fail:\n" + response.getBody(), response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void testHello(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/api");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = testRestTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        assertTrue("testGetSimpleDos Fail:\n" + response.getBody(), response.getStatusCode().is2xxSuccessful());
    }
}
