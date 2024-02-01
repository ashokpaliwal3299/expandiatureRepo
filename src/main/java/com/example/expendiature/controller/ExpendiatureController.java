package com.example.expendiature.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.expendiature.entity.Expendiature;
import com.example.expendiature.exception.IdNotPresentException;
import com.example.expendiature.exception.NoRecordsFoundException;
import com.example.expendiature.service.ExpendiatureService;

@RestController
public class ExpendiatureController {

	@Autowired
	private ExpendiatureService service;

	@GetMapping("/all-expendiature")
	public ResponseEntity<List<Expendiature>> getAllExpendiature() {
		List<Expendiature> exp = service.allExpendiature();
		return ResponseEntity.status(HttpStatus.OK).body(exp);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Expendiature> getById(@Validated @PathVariable int id) {
		Expendiature exp = service.findById(id);
		if (exp != null) {
			return ResponseEntity.status(HttpStatus.OK).body(exp);

		} else {
			throw new IdNotPresentException("id: " + id + " is not present in record.");
		}

	}

	@GetMapping("/findByName/{itemName}")
	public ResponseEntity<List<Expendiature>> findByName(@PathVariable String itemName) {
		List<Expendiature> expendiatureList = service.findByName(itemName);

		if (expendiatureList.size() == 0 || expendiatureList == null) {
			throw new IdNotPresentException(itemName + " is not present in record.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(expendiatureList);
		}
	}

	@GetMapping("/findByCategories/{categories}")
	public ResponseEntity<List<Expendiature>> findByCategories(@PathVariable String categories) {
		List<Expendiature> expendiatureList = service.findByCategories(categories);
		if (expendiatureList.isEmpty()) {
			throw new NoRecordsFoundException(
					"category " + categories + " is not present. Please select cetegory from grocery and clothes");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(expendiatureList);
		}

	}

	@GetMapping("/findByDate/{date}")
	public ResponseEntity<List<Expendiature>> findExpendiatureByDate(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<Expendiature> expendiatureList = service.findByDate(date);
		if (expendiatureList.size() == 0) {
			throw new NoRecordsFoundException(
					"the date " + date + " which you have choose, for this there is no purchasing.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(expendiatureList);
	}

	@PostMapping("/new")
	public ResponseEntity<Expendiature> addNewExpendiature(@RequestBody Expendiature exp) {
		Expendiature expend = service.addExpendiature(exp);
		return new ResponseEntity<>(expend, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Expendiature> updateExpendiature(@PathVariable int id, @RequestBody Expendiature expdetails) {
		Expendiature exp = service.findById(id);

		if (exp == null) {
			throw new IdNotPresentException("Item not found with id: " + id + " please enter valid id.");
		}

		exp.setCategory(expdetails.getCategory());
		exp.setItemName(expdetails.getItemName());
		exp.setQuantity(expdetails.getQuantity());
		exp.setPrice(expdetails.getPrice());
		exp.setDate(expdetails.getDate());

		service.save(exp);

		return ResponseEntity.status(HttpStatus.OK).body(exp);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteExpendiature(@PathVariable int id) {
		Expendiature exp = service.findById(id);

		if (exp == null) {
			throw new IdNotPresentException("Expendiature not found with id: " + id);
		} else {
			service.deleteById(id);
			return ResponseEntity.ok("Expendiature id with " + id + ", deleted succesfully");
		}
	}

}
