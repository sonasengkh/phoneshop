package com.nokorweb.phoneshop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nokorweb.phoneshop.entity.Brand;
import com.nokorweb.phoneshop.exception.ResourceNotFound;
import com.nokorweb.phoneshop.repository.BrandRepository;
import com.nokorweb.phoneshop.service.impl.BrandServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

	@Mock
	private BrandRepository brandRepository;
	
	private BrandService brandService;
	
	@BeforeEach
	public void setUp() {
		brandService = new BrandServiceImpl(brandRepository);
	}
	
	/*
	//Method 1
	@Test
	public void testSave() {
		//GIVE
		Brand brand = new Brand();
		brand.setName("Apple");
		//WHEN
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand brandReturn = brandService.save(brand);
		//THEN
		assertEquals("Apple", brandReturn.getName());
		//assertEquals(1, brandReturn.getId());	//error
	}
	*/
	
	//Method 2
	@Test
	public void testSave() {
		// Give
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1);
		// When
		brandService.save(brand);
		// Then
		verify(brandRepository, times(1)).save(brand);
		//verify(brandRepository, times(1)).delete(brand);	//error
	}
	
	@Test
	public void testGetById_success() {
		//GIVE
		Brand brand = new Brand();
		brand.setId(1);
		brand.setName("Apple");
		//WHEN
		when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
		Brand returnBrand = brandService.getById(1);
		//THEN
		assertEquals(1, returnBrand.getId());
		assertEquals("Apple", returnBrand.getName());
	}

	@Test
	public void testGetById_fail() {
		//GIVE
		//WHEN
		when(brandRepository.findById(1)).thenReturn(Optional.empty());
		//THEN
		assertThatThrownBy(()-> brandService.getById(1))
			.isInstanceOf(ResourceNotFound.class)
			.hasMessage("Can't find " + "Brand" + " Id " + 1);
	}
}
