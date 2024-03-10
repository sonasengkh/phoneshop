package com.nokorweb.phoneshop.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nokorweb.phoneshop.dto.BrandDTO;
import com.nokorweb.phoneshop.dto.PageDto;
import com.nokorweb.phoneshop.entity.Brand;
import com.nokorweb.phoneshop.mapper.BrandMapper;
import com.nokorweb.phoneshop.repository.BrandRepository;
import com.nokorweb.phoneshop.service.BrandService;

@RestController
@RequestMapping("brands")
public class BranchController {
	
	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		//Brand brand = Mapper.toEntity(brandDTO);
		Brand brand = BrandMapper.instance.toBrand(brandDTO);
		return ResponseEntity.ok(brandService.save(brand));
	}
	
	@RequestMapping("{id}")
	public ResponseEntity<?> getbyId(@PathVariable("id") Integer id){
		BrandDTO brandDTO = BrandMapper.instance.toBrandDTO( brandService.getById(id) );
		return ResponseEntity.ok(brandDTO);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateById(@RequestBody BrandDTO braDto, @PathVariable("id") Integer id){
		return ResponseEntity.ok(brandService.getUpdateById(id, braDto));
	}
	
	@RequestMapping()
	public ResponseEntity<?> getbrands(){
		return ResponseEntity.ok(
				brandService.getBrands()
					.stream()
					.map(brand -> BrandMapper.instance.toBrandDTO(brand))
					.collect(Collectors.toList())
				);
	}
	
	@RequestMapping("filter")
	public ResponseEntity<?> getBrandsByName(@RequestParam("name") String name){
		return ResponseEntity.ok(
					brandService.getBrandsByName(name)
						.stream()
						.map(brand -> BrandMapper.instance.toBrandDTO(brand))
						.collect(Collectors.toList())
				);
	}
	
	@RequestMapping("byspec")
	public ResponseEntity<?> getgetBrandsBySpec(@RequestParam Map<String, String> param){
		
		return ResponseEntity.ok(
				brandService.getBrandsBySpec(param)
					.stream()
					.map(brand -> BrandMapper.instance.toBrandDTO(brand))
					.collect(Collectors.toList())
				);
	}
	
	@RequestMapping("bypage")
	public ResponseEntity<?> getgetBrandsByPage(@RequestParam Map<String, String> param){
		Page<Brand> brandsPage = brandService.getBrandsByPage(param);
		return ResponseEntity.ok(brandsPage);
	}
	
	@RequestMapping("bypagedto")
	public ResponseEntity<?> getgetBrandsByPagedto(@RequestParam Map<String, String> param){
		Page<Brand> brandsPage = brandService.getBrandsByPage(param);
		PageDto pageDto = new PageDto(brandsPage);
		return ResponseEntity.ok(pageDto);
	}
}
