package com.shop.amazon.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.IntegerCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.amazon.entities.Product;
import com.shop.amazon.repositries.ProductRepo;

@Service
public class ProductServicesImpl implements ProductServices {
    // hard code adding products to the list
    // Later, we will fetch from db
    private List<Product> list;
    
    @Autowired
    ProductRepo productRepo;

    public ProductServicesImpl() {
        list = new ArrayList<>();
        list.add(new Product(121, "Electronics",
                "Samsung S24",
                "Samsung premium segment device", "121000"));

        list.add(new Product(122, "Electronics",
                "Lenovo v130",
                "Computer Notebook, intel i5 8th gen 8250u, 4Gb+1Tb", "46000"));

        list.add(new Product(154, "Clothing",
                "Levi's Shirt",
                "Fully cotton shirt with american branding", "3670"));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        for (Product obj : list) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        

        return null;

    }

    @Override
    public Product addProductNow(Product product) {
        list.add(product);
        return product;
    }

    @Override
    public List<Product> deleteProductById(int id) {
        for (Product obj : list) {
            if (obj.getId() == id) {
                list.remove(obj);
                return list;
            }
        }

        return null;
    }

}
