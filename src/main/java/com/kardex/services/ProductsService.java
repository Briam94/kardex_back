package com.kardex.services;

import com.kardex.dto.GenericAnswerDto;

public interface ProductsService {
	
	public GenericAnswerDto regisProducts(String product);
	public GenericAnswerDto UpdateProducts(String product);
	public GenericAnswerDto getProducts();

}
