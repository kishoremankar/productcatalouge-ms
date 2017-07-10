package app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	public List<Product> findProductByProductType(String productType);
	
	public List<Product> findProductByProductTypeOrProductName(String productType,String productName);
}
