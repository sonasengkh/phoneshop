package com.nokorweb.phoneshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nokorweb.phoneshop.dto.ModelDto;
import com.nokorweb.phoneshop.entity.Model;
import com.nokorweb.phoneshop.mapper.ModelMapper;
import com.nokorweb.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	private final ModelService modelService;
	private final ModelMapper modelMapper;
	
	@PostMapping
	//@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ModelDto modelDto){
		Model model = modelMapper.toModel(modelDto);
		Model modelSave = modelService.save(model);
		return ResponseEntity.ok(modelMapper.toModelDto(modelSave));
	}
	
}
