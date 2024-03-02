package com.nokorweb.phoneshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokorweb.phoneshop.dto.BrandDTO;
import com.nokorweb.phoneshop.entity.Brand;
import com.nokorweb.phoneshop.exception.ResourceNotFound;
import com.nokorweb.phoneshop.repository.BrandRepository;
import com.nokorweb.phoneshop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand save(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		return brandRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFound("Brand", id));
	}

	@Override
	public Brand getUpdateById(Integer id, BrandDTO brandDtoUpdtate) {
		Brand brand = getById(id);
		brand.setName(brandDtoUpdtate.getName());
		return brandRepository.save(brand);
	}


}
