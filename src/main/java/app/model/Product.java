package app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "current_price")
public class Product {
private Double price;
private Long productId;
private String productName;
private String productType;
private String image;
private String description;
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Long getProductId() {
	return productId;
}
public void setProductId(Long productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Id
private String id;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

}
