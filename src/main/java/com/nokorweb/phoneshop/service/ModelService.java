package com.nokorweb.phoneshop.service;

import java.util.List;

import com.nokorweb.phoneshop.entity.Model;

public interface ModelService {
	Model save(Model model);
	List<Model> getByBrand(Integer brandId);
}
