package com.example.demo3;

import com.example.demo3.controllers.FormController;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo3ApplicationTests {

	@Autowired
	FormController formController;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(formController);
		Assertions.assertThat(formController).isNotNull();
		Assert.assertThat(formController, Matchers.notNullValue());
	}

}
