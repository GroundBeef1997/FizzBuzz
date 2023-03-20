package com.FizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FizzBuzz.exception.ResourceNotFoundException;
import com.FizzBuzz.model.Fizzbuzz;
import com.FizzBuzz.repository.FizzbuzzRepository;

@Service
@Transactional
public class FizzbuzzService {

	@Autowired
	private FizzbuzzRepository fizzBuzzRepository;
	
	public List<Fizzbuzz> getAllFizzbuzzs() {
		return fizzBuzzRepository.findAll();
	}
	
	public Fizzbuzz getFizzbuzzById(Long id) {
		Fizzbuzz f =  fizzBuzzRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("la ressource que vous recherchez n'existe pas"));
		return f;
	}
	
	public Fizzbuzz getFizzbuzzFromValue(Fizzbuzz f) {
		
		List<String> resultats = new ArrayList<>();
		for (int i=1; i<=f.getEntryValue(); i++) {			
			if (i%3 == 0 && i%5 == 0) {
				resultats.add("Fizzbuzz");			
			} else if (i%5 == 0) {
				resultats.add("Buzz");
			} else if (i%3 == 0) {
				resultats.add("Fizz");				
			} else {
				resultats.add(Integer.toString(i));
			}
			//System.err.println("test: " + resultats);
		}
		f.setResultats(resultats);
		return fizzBuzzRepository.save(f);
	}
}
