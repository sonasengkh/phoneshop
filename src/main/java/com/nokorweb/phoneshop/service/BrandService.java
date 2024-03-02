package com.nokorweb.phoneshop.service;

import com.nokorweb.phoneshop.dto.BrandDTO;
import com.nokorweb.phoneshop.entity.Brand;

public interface BrandService {
	Brand save(Brand brand);
	Brand getById(Integer id);
	Brand getUpdateById(Integer id, BrandDTO brandDtoUpdtate);
	
}
