package com.kardex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kardex.services.ProductsService;
import com.kardex.utils.Constans;

@CrossOrigin
@RestController
@RequestMapping(Constans.PRODUCT_REQUEST_MAPPING)
public class ProductController {
	
	@Autowired
	private ProductsService productService;
	

    @RequestMapping(value = Constans.PRODUCT_CREATE, method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody String trama) {
    	return new ResponseEntity<>(productService.regisProducts(trama), HttpStatus.OK);
    }

    @RequestMapping(value = Constans.PRODUCT_UPDATE, method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody String trama) {
    	return new ResponseEntity<>(productService.UpdateProducts(trama), HttpStatus.OK);
    }

    @RequestMapping(value = Constans.PRODUCT_GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getProducts() {
    	return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

}
