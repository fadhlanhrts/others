package jmart.goldenSample.controller;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jmart.goldenSample.Algorithm;
import jmart.goldenSample.dataset.*;
import jmart.goldenSample.dbjson.*;

@RestController
@RequestMapping("/product")
class ProductController implements BasicGetController<Product>
{
	@JSONDBContainer(value=Product.class, filepath="db/product.json")
	public static JSONTable<Product> productTable;
	
	@Override
	public JSONTable<Product> getJSONTable() { return productTable; }
	
	@RequestMapping(value="/store/{id}", method=RequestMethod.GET)
    List<Product> getProductByStore(@PathVariable int id)
    {
    	return Algorithm.<Product>collect(ProductController.productTable, (e) -> e.storeId == id);
    }
	
    @RequestMapping(value="/create", method=RequestMethod.POST)
    boolean create
    (
    		@RequestParam int storeId,
            @RequestParam String name,
            @RequestParam int weight,
            @RequestParam boolean conditionUsed,
            @RequestParam double discount,
            @RequestParam double price,
            @RequestParam ProductCategory category
    )
    {
        boolean success = false;
        try
        {
        	final Product product = new Product(storeId, name, weight, conditionUsed, discount, price, category, null);
        	productTable.add(product);
        	success = true;
        }
        catch (Throwable throwable) { throwable.printStackTrace(); }
        return success;
    }
}