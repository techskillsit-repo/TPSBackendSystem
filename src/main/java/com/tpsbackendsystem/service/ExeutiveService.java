package com.tpsbackendsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tpsbackendsystem.model.Executive;
import com.tpsbackendsystem.repository.ExecutiveRepository;

@Service
public class ExeutiveService {
	@Autowired
	private ExecutiveRepository executiveRepository;

	public Executive save(Executive executive) {
		// TODO Auto-generated method stub
		return executiveRepository.save(executive);
	}

	public List<Executive> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return executiveRepository.findAll();
	}

	public Executive getOne(Long id) {
		// TODO Auto-generated method stub
		return executiveRepository.getOne(id);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		executiveRepository.deleteById(id);
		
	}

}
