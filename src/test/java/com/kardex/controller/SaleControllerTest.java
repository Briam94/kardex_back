package com.kardex.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kardex.dto.GenericAnswerDto;
import com.kardex.services.SalesService;

public class SaleControllerTest {

	public static final String GENERIC_ANSWER = "Exitoso.";
	
	@InjectMocks
	private SaleController saleController;
	@Mock
	private SalesService saleService;

	private GenericAnswerDto genericAnswer;
	private String sale;
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		setResponseGenericAnswer();
		setNewSale();
		Mockito.when(saleService.createSale(sale)).thenReturn(genericAnswer);
	}
	
	@Test
	public void createSale() {
		ResponseEntity<?> response = saleController.createSale(sale);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody());
	}

	public void setResponseGenericAnswer() {
		genericAnswer = new GenericAnswerDto("1", GENERIC_ANSWER, null);
	}

	public void setNewSale() {
		sale = "{\r\n"
				+ "    \"data\": [\r\n"
				+ "        {\r\n"
				+ "        \"salesUser\": 2,\r\n"
				+ "        \"salesProduct\": 1,\r\n"
				+ "        \"salesProductAmount\": 5,\r\n"
				+ "        \"salesPrice\": \"12.000\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "        \"salesUser\": 2,\r\n"
				+ "        \"salesProduct\": 2,\r\n"
				+ "        \"salesProductAmount\": 5,\r\n"
				+ "        \"salesPrice\": \"12.000\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
	}

}
