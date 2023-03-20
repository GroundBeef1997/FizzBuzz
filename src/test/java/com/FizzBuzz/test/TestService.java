package com.FizzBuzz.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.FizzBuzz.model.Fizzbuzz;
import com.FizzBuzz.service.FizzbuzzService;

@SpringBootTest
public class TestService {

	@Autowired
	private FizzbuzzService service;
	
	//-------------------- test la reception des données ------------------------------------
	@Test
	public void getTest () {
		Fizzbuzz testObject = new Fizzbuzz();
		List<String> list = new ArrayList<>();
		testObject.setEntryValue(3);
		testObject.setId(1);
		list.add("1");
		list.add("2");
		list.add("Fizz");
		testObject.setResultats(list);
		Fizzbuzz result = service.getFizzbuzzFromValue(testObject);
		
		assertEquals(result.getId(), testObject.getId());
	}
	
	@Test
	public void getAllTest () {
		Fizzbuzz testObject = new Fizzbuzz();
		List<String> list = new ArrayList<>();
		testObject.setEntryValue(3);
		testObject.setId(1);
		list.add("1");
		list.add("2");
		list.add("Fizz");
		testObject.setResultats(list);
		service.getFizzbuzzFromValue(testObject);
		
		Fizzbuzz testObject2 = new Fizzbuzz();
		List<String> list2 = new ArrayList<>();
		testObject2.setEntryValue(5);
		testObject2.setId(2);
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("4");
		list2.add("Buzz");
		testObject2.setResultats(list2);
		service.getFizzbuzzFromValue(testObject2);
		
		List<Fizzbuzz> fizzbuzzs = service.getAllFizzbuzzs();
		assertEquals(fizzbuzzs.get(0).getId(), testObject.getId());
		assertEquals(fizzbuzzs.get(1).getId(), testObject2.getId());
	}
	
	//-------------------- test l'envoie des données pour une entré egale à 3 ------------------------------------
	@Test
	public void postTest () {
		Fizzbuzz testObject = new Fizzbuzz();	
		testObject.setEntryValue(3);
		testObject.setId(1);
		
		Fizzbuzz result = service.getFizzbuzzFromValue(testObject);
		
		List<String> expecetdListOutput = new ArrayList<>();
		expecetdListOutput.add("1");
		expecetdListOutput.add("2");
		expecetdListOutput.add("Fizz");
		
		assertEquals(result.getId(), testObject.getId());
		assertEquals(result.getEntryValue(), testObject.getEntryValue());
		assertEquals(expecetdListOutput, testObject.getResultats());
	}
	
	
}
