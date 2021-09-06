package com.kardex.controller;

import com.kardex.dto.GenericAnswerDto;
import com.kardex.services.ProductsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductControllerTest {

    public static final String GENERIC_ANSWER = "Exitoso.";

    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductsService productsService;

    private GenericAnswerDto genericAnswer;
    private String newProduct;
    private String updateProduct;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        setResponseGenericAnswer();
        setNewProduct();
        Mockito.when(productsService.regisProducts(newProduct)).thenReturn(genericAnswer);
        Mockito.when(productsService.UpdateProducts(updateProduct)).thenReturn(genericAnswer);
        Mockito.when(productsService.getProducts()).thenReturn(genericAnswer);
    }

    @Test
    public void createProduct() {
        ResponseEntity<?> response = productController.createProduct(newProduct);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
    }

    @Test
    public void updateProduct() {
        ResponseEntity<?> response = productController.updateProduct(updateProduct);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
    }

    @Test
    public void getProducts() {
        ResponseEntity<?> response = productController.getProducts();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
    }

    public void setResponseGenericAnswer() {
        genericAnswer = new GenericAnswerDto("1", GENERIC_ANSWER, null);
    }

    public void setNewProduct(){
        newProduct = "{\n" +
                "    \"data\": {\n" +
                "        \"producName\": \"camiseta batman\",\n" +
                "        \"productDescription\": \"talla L\",\n" +
                "        \"product_stock\": 5\n" +
                "    }\n" +
                "}";
    }

    public void setUpdateProduct(){
        updateProduct = "{\n" +
                "    \"data\": {\n" +
                "        \"productId\": 1,\n" +
                "        \"producName\": \"camiseta batman\",\n" +
                "        \"productDescription\": \"talla L\",\n" +
                "        \"product_stock\": 4\n" +
                "    }\n" +
                "}";
    }
}
