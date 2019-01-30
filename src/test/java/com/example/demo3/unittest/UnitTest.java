package com.example.demo3.unittest;

import com.example.demo3.controllers.FormController;
import com.example.demo3.model.Form;
import com.example.demo3.services.FormService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FormController.class)
public class UnitTest {

    @MockBean
    FormService formService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete() throws Exception {
        Form form = new Form(1, "test","test", "1","1", "test", "1","test");
        List<Form> forms = Arrays.asList(form);
        Mockito.when(formService.findAll()).thenReturn(forms);
     mockMvc.perform(get("/form"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", Matchers.hasSize(1)))
            .andExpect(jsonPath("$[0].town", Matchers.is("test")));
}




}
