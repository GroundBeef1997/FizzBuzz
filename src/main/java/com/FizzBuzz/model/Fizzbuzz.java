package com.FizzBuzz.model;

import java.util.Collection;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Entity(name = "Fizzbuzz")
@Table(name="Fizzbuzz")
public class Fizzbuzz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "entryvalue")
	private int entryvalue;
	
	@Column(name = "resultats")
	private List<String> resultats;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEntryValue() {
		return entryvalue;
	}

	public void setEntryValue(int entryValue) {
		this.entryvalue = entryValue;
	}

	public List<String> getResultats() {
		return resultats;
	}

	public void setResultats(List<String> resultats) {
		this.resultats = resultats;
	}
}
