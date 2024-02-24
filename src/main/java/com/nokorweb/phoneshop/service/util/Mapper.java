package com.nokorweb.phoneshop.service.util;

import com.nokorweb.phoneshop.dto.BrandDTO;
import com.nokorweb.phoneshop.entity.Brand;

public class Mapper {

	public static Brand toEntity(BrandDTO branDto) {
		Brand brand = new Brand();
		//brand.setId(branDto.getId());
		brand.setName(branDto.getName());
		return brand;
	}
	
	public static BrandDTO toDto(Brand brand) {
		BrandDTO brandDTO =new BrandDTO();
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}
