package com.nokorweb.phoneshop.service.impl;

import org.springframework.stereotype.Service;

import com.nokorweb.phoneshop.entity.Model;
import com.nokorweb.phoneshop.repository.ModelRepository;
import com.nokorweb.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService{

	private final ModelRepository modelRepository;
	
	@Override
	public Model save(Model model) {
		return modelRepository.save(model);
	}

}
