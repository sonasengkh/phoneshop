package com.nokorweb.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.nokorweb.phoneshop.dto.ModelDto;
import com.nokorweb.phoneshop.entity.Model;
import com.nokorweb.phoneshop.service.BrandService;

@Mapper(componentModel = "spring",uses = {BrandService.class} )
public interface ModelMapper {

	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target = "brand", source = "brandId")
	Model toModel(ModelDto modelDto);
	
	@Mapping(target = "brandId", source = "brand.id")
	ModelDto toModelDto(Model model);
	
}
