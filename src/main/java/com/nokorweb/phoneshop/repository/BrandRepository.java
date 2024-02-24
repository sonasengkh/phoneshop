package com.nokorweb.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nokorweb.phoneshop.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
