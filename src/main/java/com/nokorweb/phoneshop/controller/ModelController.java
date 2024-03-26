package com.nokorweb.phoneshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nokorweb.phoneshop.dto.ModelDto;
import com.nokorweb.phoneshop.entity.Model;
import com.nokorweb.phoneshop.mapper.ModelEntityMapper;
import com.nokorweb.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	private final ModelService modelService;
	private final ModelEntityMapper modelEntityMapper;
	
	@PostMapping
	//@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ModelDto modelDto){
		Model model = modelEntityMapper.toModel(modelDto);
		Model modelSave = modelService.save(model);
		return ResponseEntity.ok(modelEntityMapper.toModelDto(modelSave));
	}
	
}
