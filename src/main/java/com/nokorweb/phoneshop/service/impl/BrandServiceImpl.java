package com.nokorweb.phoneshop.service.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nokorweb.phoneshop.dto.BrandDTO;
import com.nokorweb.phoneshop.entity.Brand;
import com.nokorweb.phoneshop.exception.ResourceNotFound;
import com.nokorweb.phoneshop.repository.BrandRepository;
import com.nokorweb.phoneshop.service.BrandService;
import com.nokorweb.phoneshop.service.util.PageUtil;
import com.nokorweb.phoneshop.spec.BrandFilter;
import com.nokorweb.phoneshop.spec.BrandSpec;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private final BrandRepository brandRepository;
	
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

	@Override
	public List<Brand> getBrands() {
		return brandRepository.findAll();
	}

	@Override
	public List<Brand> getBrandsByName(String name) {
		//return brandRepository.findByNameContaining(name);
		//return brandRepository.findByNameLike(name);
		return brandRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Brand> getBrandsBySpec(Map<String, String> param) {
		BrandFilter brandFilter = new BrandFilter();
		
		if (param.containsKey("name")) {
			brandFilter.setName( param.get("name") );
		}
		if(param.containsKey("id")) {
			brandFilter.setId(
					Integer.parseInt( param.get("id") )
					);
		}

		BrandSpec brandSpec = new BrandSpec(brandFilter);
		return brandRepository.findAll(brandSpec);
	}

	@Override
	public Page<Brand> getBrandsByPage(Map<String, String> param) {
		BrandFilter brandFilter = new BrandFilter();
		
		if (param.containsKey("name")) {
			brandFilter.setName( param.get("name") );
		}
		if(param.containsKey("id")) {
			brandFilter.setId(
					Integer.parseInt( param.get("id") )
					);
		}
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if (param.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt( param.get(PageUtil.PAGE_LIMIT) );
		}
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if (param.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt( param.get(PageUtil.PAGE_NUMBER) );
		}
		
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		
		Page<Brand> brands = brandRepository.findAll(brandSpec, pageable);
		
		return brands;
	}


}
