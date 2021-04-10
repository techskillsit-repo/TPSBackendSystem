package com.tpsbackendsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tpsbackendsystem.model.Executive;
import com.tpsbackendsystem.repository.ExecutiveRepository;

@Service
public class ExecutiveService {

	@Autowired
	private ExecutiveRepository executiveRepository;
	
	public Executive getOne(Long eid) {
		Executive executive = executiveRepository.getOne(eid);
		return executive;
	}

	public Executive save(Executive executive) {
		return executiveRepository.save(executive);
	}

	public List<Executive> findAll(Pageable pageable) {
		return executiveRepository.findAll(pageable).getContent();
	}

	public void deleteById(Long id) {
		executiveRepository.deleteById(id);		
	}

}
