package com.kardex.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kardex.dao.ProductsDao;
import com.kardex.dto.GenericAnswerDto;
import com.kardex.entities.Products;
import com.kardex.services.ProductsService;
import com.kardex.utils.Constans;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	private ProductsDao productsDao;

	@Override
	public GenericAnswerDto regisProducts(String product) {
		GenericAnswerDto genericAnswer = new GenericAnswerDto();
		try {
			JSONObject obj = new JSONObject(product);
			Products products = new Products(null,
					obj.getJSONObject("data").getString("producName"),
					obj.getJSONObject("data").getString("productDescription"),
					obj.getJSONObject("data").getLong("productStock"),
					obj.getJSONObject("data").getLong("productPrice"));
			productsDao.update(products);
			genericAnswer.setCode("1");
			genericAnswer.setMessage(Constans.PRODUCT_CREATED_SUCCESFULL);
		} catch (Exception e) {
			genericAnswer.setCode("0");
			genericAnswer.setMessage(Constans.ERROR_GENERAL);
		}
		return genericAnswer;
	}
	

	@Override
	public GenericAnswerDto UpdateProducts(String product) {
		GenericAnswerDto genericAnswer = new GenericAnswerDto();
		try {
			JSONObject obj = new JSONObject(product);
			Products products = new Products(obj.getJSONObject("data").getLong("productId"),
					obj.getJSONObject("data").getString("producName"),
					obj.getJSONObject("data").getString("productDescription"),
					obj.getJSONObject("data").getLong("productStock"),
					obj.getJSONObject("data").getLong("productPrice"));
			productsDao.update(products);
			genericAnswer.setCode("1");
			genericAnswer.setMessage(Constans.PRODUCT_UPDATE_SUCCESFULL);
		} catch (Exception e) {
			genericAnswer.setCode("0");
			genericAnswer.setMessage(Constans.ERROR_GENERAL);
		}
		return genericAnswer;
	}


	@Override
	public GenericAnswerDto getProducts() {
		GenericAnswerDto genericAnswer = new GenericAnswerDto();
		try {
			List<Products> listProducts = new ArrayList<Products>();
			listProducts = productsDao.findAll();
			genericAnswer.setCode("1");
			genericAnswer.setMessage(Constans.PRODUCTS_GET_SUCCESFULL);
			genericAnswer.setDescription(listProducts);
		} catch (Exception e) {
			genericAnswer.setCode("0");
			genericAnswer.setMessage(Constans.ERROR_GENERAL);
			e.printStackTrace();
		}
		return genericAnswer;
	}

}
