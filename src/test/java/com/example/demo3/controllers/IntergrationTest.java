package com.example.demo3.controllers;

import com.example.demo3.model.Form;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntergrationTest {

    @Autowired
    FormController formController;

    @Test
    public void testCreateReadDelete() throws Exception{
    Form form = new Form(1, "abcde","test", "1","1", "test", "1","test");
    Form formResult = formController.save(form);
    Iterable<Form> forms = formController.getForm();
    Assertions.assertThat(forms).first().hasFieldOrPropertyWithValue("town", "lech");
//    formController.deleteForm(formResult.getId());
//    Assertions.assertThat(formController.getForm()).isEmpty();
    }


}
