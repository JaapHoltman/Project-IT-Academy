package com.example.demo3.system;

import com.example.demo3.model.Form;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SystemTest {

    @Test
    public void testCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/form";
        Form form = new Form(1, "abcd","test", "1","1", "test", "1","test" );
        ResponseEntity<Form> entity = restTemplate.postForEntity(url, form, Form.class);
        Form[] forms = restTemplate.getForObject(url, Form[].class);
        Assertions.assertThat(forms).extracting(Form::getTown).contains("abcd");
        restTemplate.delete(url + "/" + entity.getBody().getId());
       // Assertions.assertThat(restTemplate.getForObject(url, Form[].class)).isEmpty();
    }
}
