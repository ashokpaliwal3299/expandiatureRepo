package com.example.expendiature.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expendiature.entity.Expendiature;
import com.example.expendiature.exception.NoRecordsFoundException;
import com.example.expendiature.repository.ExpendiatureRepository;

@Service
public class ExpendiatureService {

	@Autowired
	private ExpendiatureRepository repo;

	public List<Expendiature> allExpendiature() {
		List<Expendiature> listExp = repo.findAll();
		if (listExp.size() == 0 || listExp.isEmpty()) {
			throw new NoRecordsFoundException("No records found.");
		} else {
			return listExp;
		}

	}

	public Expendiature addExpendiature(Expendiature exp) {
		return repo.save(exp);
	}

	public Expendiature findById(int id) {
		return repo.findById(id);
	}

	public void save(Expendiature exp) {
		repo.save(exp);
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

	public List<Expendiature> findByName(String itemName) {
		return repo.findByItemName(itemName);
	}

	public void save(List<Expendiature> e) {
		repo.saveAll(e);

	}

	public List<Expendiature> findByCategories(String itemName) {
		return repo.findByCategory(itemName);
	}

	public List<Expendiature> findByDate(Date date) {
		return repo.findByDate(date);
	}

}
