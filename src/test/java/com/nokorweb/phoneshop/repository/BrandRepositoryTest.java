package com.nokorweb.phoneshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.nokorweb.phoneshop.entity.Brand;

@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;
	@Test
	public void testFindByNameLike() {
		//Give
		Brand brand1 = new Brand();
		brand1.setName("Apple");
		Brand brand2 = new Brand();
		brand2.setName("SAmsung");
		brandRepository.save(brand1);
		brandRepository.save(brand2);
		//When
		List<Brand> brands = brandRepository.findByNameLike("%A%");
		//Then
		assertEquals(2, brands.size());
		assertEquals("Apple", brands.get(0).getName());
		assertEquals(2, brands.get(1).getId());
	}
}
