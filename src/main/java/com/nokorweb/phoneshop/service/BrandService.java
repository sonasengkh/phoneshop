package com.nokorweb.phoneshop.service;

import java.util.List;

import com.nokorweb.phoneshop.dto.BrandDTO;
import com.nokorweb.phoneshop.entity.Brand;

public interface BrandService {
	Brand save(Brand brand);
	Brand getById(Integer id);
	Brand getUpdateById(Integer id, BrandDTO brandDtoUpdtate);
	
	List<Brand> getBrands();
	List<Brand> getBrandsByName(String name);
}
