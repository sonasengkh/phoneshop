package com.nokorweb.phoneshop.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PageDto {
	private List<?> list;
	private PaginationDto paginationDto;
	
	public PageDto(Page<?> page) {
		this.list = page.getContent();
		paginationDto = PaginationDto.builder()
					.empty(page.isEmpty())
					.first(page.isFirst())
					.last(page.isLast())
					.pageSize(page.getPageable().getPageSize())
					.pageNumber(page.getPageable().getPageNumber()+1)
					.totalPages(page.getTotalPages())
					.totalElements(page.getTotalElements())
					.numberOfElements(page.getNumberOfElements())
					.build();
	}

}
