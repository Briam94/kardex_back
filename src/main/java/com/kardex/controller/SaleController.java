package com.kardex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kardex.services.SalesService;
import com.kardex.utils.Constans;

@CrossOrigin
@RestController
@RequestMapping(Constans.SALE_REQUEST_MAPPING)
public class SaleController {
	
	@Autowired
	private SalesService saleService;
	

    @RequestMapping(value = Constans.SALE_CREATE, method = RequestMethod.POST)
    public ResponseEntity<?> createSale(@RequestBody String trama) {
    	return new ResponseEntity<>(saleService.createSale(trama), HttpStatus.OK);
    }
    

}
