package com.example.expendiature.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expendiature.entity.Expendiature;

@Repository
public interface ExpendiatureRepository extends JpaRepository<Expendiature, Integer>{
	
	Expendiature findById(int id);

	List<Expendiature> findByItemName(String itemName);
	
	List<Expendiature> findByCategory(String category);

	List<Expendiature> findByDate(Date date);

}
