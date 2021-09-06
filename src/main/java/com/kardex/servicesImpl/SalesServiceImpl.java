package com.kardex.servicesImpl;

import java.util.Date;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kardex.dao.ProductsDao;
import com.kardex.dao.SalesDao;
import com.kardex.dao.UsersDao;
import com.kardex.dto.GenericAnswerDto;
import com.kardex.entities.Products;
import com.kardex.entities.Sales;
import com.kardex.entities.Users;
import com.kardex.services.SalesService;
import com.kardex.utils.Constans;

@Service
public class SalesServiceImpl implements SalesService{
	
	@Autowired
	private SalesDao salesDao;
	
	@Autowired
	private UsersDao userDao;
	
	@Autowired
	private ProductsDao productDao;

	@Override
	public GenericAnswerDto createSale(String sale) {
		GenericAnswerDto genericAnswer = new GenericAnswerDto();
		Date date = new Date();
		try {
			JSONObject obj = new JSONObject(sale);
    		JSONArray saleArray = obj.getJSONArray("data");
    		for (int i = 0; i < saleArray.length(); i++) {
    			Long stockAmount = saleArray.getJSONObject(i).getLong("salesProductAmount");
    			Long userId = saleArray.getJSONObject(i).getLong("salesUser");
    			Users user = new Users();
    			user = userDao.find(userId);
    			Long productId = saleArray.getJSONObject(i).getLong("salesProduct");
    			Products product = new Products();
    			product = productDao.find(productId);
    			Sales sales = new Sales(null,
    					product,
    					stockAmount,
    					saleArray.getJSONObject(i).getString("salesPrice"),
    					user,
    					date
    					);
    			salesDao.update(sales);
    			Long newStock = product.getProductStock() - stockAmount;
    			product.setProductStock(newStock);
    			productDao.update(product);
			}
			genericAnswer.setCode("1");
			genericAnswer.setMessage(Constans.SALES_CREATED_SUCCESFULL);
		} catch (Exception e) {
			genericAnswer.setCode("0");
			genericAnswer.setMessage(Constans.ERROR_GENERAL);
			e.printStackTrace();
		}
		return genericAnswer;
	}

}
