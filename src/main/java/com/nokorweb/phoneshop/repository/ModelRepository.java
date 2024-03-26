package com.nokorweb.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nokorweb.phoneshop.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>{
	List<Model> findByBrandId(Integer branId);
	//List<Model> findByBrandIdAndNameStartWith(Integer brandId, String name);
}
