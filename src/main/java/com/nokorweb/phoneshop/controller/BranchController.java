package com.nokorweb.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nokorweb.phoneshop.dto.BrandDTO;
import com.nokorweb.phoneshop.entity.Brand;
import com.nokorweb.phoneshop.service.BrandService;
import com.nokorweb.phoneshop.service.util.Mapper;

@RestController
@RequestMapping("brands")
public class BranchController {
	
	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toEntity(brandDTO);
		return ResponseEntity.ok(brandService.save(brand));
		//return ResponseEntity.ok(Mapper.toDto(brandService.save(brand)));
	}
	
	@RequestMapping("{id}")
	public ResponseEntity<?> getbyId(@PathVariable("id") Integer id){
		return ResponseEntity.ok(brandService.getById(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateById(@RequestBody BrandDTO braDto, @PathVariable("id") Integer id){
		return ResponseEntity.ok(brandService.getUpdateById(id, braDto));
	}
}
