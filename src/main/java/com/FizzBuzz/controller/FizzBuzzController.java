package com.FizzBuzz.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FizzBuzz.model.Fizzbuzz;
import com.FizzBuzz.service.FizzbuzzService;

@RestController
@RequestMapping("/api/V1")
public class FizzBuzzController {

	@Autowired
	private FizzbuzzService fizzBuzzService;

	// Permet de retrouver toutes les tentatives
	@GetMapping("/fizzbuzzs")
	public List<Fizzbuzz> getAllFizzBuzzs() {
		List<Fizzbuzz> f = fizzBuzzService.getAllFizzbuzzs();
		for (Fizzbuzz value : f) {
			System.err.println(" fizzBuzz : " + value.getResultats());
		}

		return fizzBuzzService.getAllFizzbuzzs();
	}

	// Permet de faire l'exercice
	@PostMapping("/fizzbuzz")
	public Fizzbuzz addFizzBuzz(@RequestBody Fizzbuzz fizzBuzz) {
		return fizzBuzzService.getFizzbuzzFromValue(fizzBuzz);
	}

	// Permet de retrouver un exercice selon son identifiant
	@GetMapping("/fizzbuzz/{id}")
	public ResponseEntity<Fizzbuzz> getFizzbuzzById(@PathVariable Long id) {
		Fizzbuzz f = fizzBuzzService.getFizzbuzzById(id);
		return ResponseEntity.ok(f);
	}

	@GetMapping("/hello")
	public String getTest() {
		return "hello";
	}
}
