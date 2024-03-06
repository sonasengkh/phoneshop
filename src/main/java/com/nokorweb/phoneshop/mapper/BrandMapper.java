package com.nokorweb.phoneshop.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nokorweb.phoneshop.dto.BrandDTO;
import com.nokorweb.phoneshop.entity.Brand;

@Mapper
public interface BrandMapper {
	BrandMapper instance = Mappers.getMapper(BrandMapper.class);
	
	//@Mapping(target = "version", source = "vs")
	Brand toBrand(BrandDTO brandDTO);
	
	//@Mapping( target = "vs",source = "version")
	BrandDTO toBrandDTO(Brand brand);
}
