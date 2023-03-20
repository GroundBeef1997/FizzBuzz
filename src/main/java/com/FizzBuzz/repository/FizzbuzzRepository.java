package com.FizzBuzz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FizzBuzz.model.Fizzbuzz;

@Repository
public interface FizzbuzzRepository extends JpaRepository <Fizzbuzz, Long> {
	Optional<Fizzbuzz> findById(Long id);
}
