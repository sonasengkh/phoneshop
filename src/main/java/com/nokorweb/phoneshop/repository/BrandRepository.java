package com.nokorweb.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nokorweb.phoneshop.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand>{
	List<Brand> findByNameLike(String name);
	List<Brand> findByNameContaining(String name);
	List<Brand> findByNameContainingIgnoreCase(String name);
}
