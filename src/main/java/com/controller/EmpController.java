package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.query.model.Emp;

import repositary.EmpRepositary;

@RestController
public class EmpController {

	@Autowired
	private EmpRepositary repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Emp> getEmpData() {
		
		List<Emp> response=repo.findAll();
		return response;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Emp addEmp(@RequestBody Emp emp){
		
		repo.save(emp);
		return emp;
		
	}
	
}
