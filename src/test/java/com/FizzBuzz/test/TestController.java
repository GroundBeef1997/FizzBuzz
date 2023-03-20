package com.FizzBuzz.test;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.FizzBuzz.model.Fizzbuzz;
import com.FizzBuzz.service.FizzbuzzService;

@SpringBootTest
@AutoConfigureMockMvc
public class TestController {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private FizzbuzzService service;

	// test de controleur basique
	@Test
	public void basicControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/V1/hello")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	// test de la fonction principale
	@Test
	public void getFizzbuzzTest() throws Exception {

		Fizzbuzz testObject = new Fizzbuzz();	
		testObject.setEntryValue(3);
		service.getFizzbuzzFromValue(testObject);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/V1/fizzbuzz/" +  testObject.getId()).accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.err.println(result.getResponse().getContentAsString());
		System.err.println(" vs ");
		System.err.println(result.getResponse().getContentAsString());
		
		String expected = "{\"id\":1, \"resultats\":[\"1\",\"2\",\"Fizz\"],\"entryValue\":3}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
