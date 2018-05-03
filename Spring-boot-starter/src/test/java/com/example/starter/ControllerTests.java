package com.example.starter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTests {

	@Autowired
	RestClient restClient;

	@Test
	public void testSayHello() throws Exception {
		StarterRestController controller = new StarterRestController();
		// Model model = new BindingAwareModelMap();
		String result = controller.sayHello("World");
		// assertEquals("World", model.asMap().get("user"));
		assertEquals("hello : World", result);
	}

	@Test
	public void testRestClient() throws Exception {
		String result = restClient.search("IND", "WB");
		System.out.println(result);
		assertNotNull(result);
	}
}
