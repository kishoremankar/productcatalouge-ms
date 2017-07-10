package app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Product;
import app.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/product")
@Api(value="productCatalouge", description="Operations pertaining to products in catalouge")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;
  
  @ApiOperation(value = "update desired product", response = String.class)
  @RequestMapping(method = RequestMethod.PUT, value="/")
  public String editProduct(@RequestBody Product product){
   productRepository.save(product);
    String response = "Product updated successfully";
    return response;
  }
  
  @ApiOperation(value = "Add product", response = String.class)
  @RequestMapping(method = RequestMethod.POST, value="/")
  public String AddProduct(@RequestBody Product product){
   productRepository.save(product);
    String response = "Product added  successfully";
    return response;
  }
  
  /**
 * @param productType
 * @return
 */
  @ApiOperation(value = "retreive desired product by passing productId", response = String.class)
@RequestMapping(method = RequestMethod.GET, value="/{id}")
  public Product GetProduct(@PathVariable(value="id") String id){
   Product product = productRepository.findOne(id);
    return product;
  }
  @ApiOperation(value = "retrieve required products by filtering with productType or productName", response = List.class)
  @RequestMapping(method = RequestMethod.GET, value="/products")
  public List<Product> GetProducts(@RequestParam(value="productType") String productType,@RequestParam(value="productName") String productName){
   List<Product> products = productRepository.findProductByProductTypeOrProductName(productType, productName);
    return products;
  }
  
  @ApiOperation(value = "retrieve all products", response = List.class)
  @RequestMapping(method = RequestMethod.GET, value="/")
  public List<Product> GetAllProducts(){
   List<Product> currentPriceList = productRepository.findAll();
    return currentPriceList;
  }
  
  @ApiOperation(value = "delete product by paasing id", response = String.class)
  @RequestMapping(method = RequestMethod.DELETE, value="/{id}")
  public String GetAllProducts(@PathVariable(value="id") String id){
	  String response=null;
	  try{
   productRepository.delete(id);
   response = "Product has been deleted successfully";
	  }catch(Exception e){
		  response = e.getMessage();
	  }
	  
    return response;
  }

}
