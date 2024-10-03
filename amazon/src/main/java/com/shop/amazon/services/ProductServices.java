package com.shop.amazon.services;

import java.util.List;


import com.shop.amazon.entities.Product;

public interface ProductServices  {
    public List<Product> getAllProduct();
    public Product getProductById(int id);

    public Product addProductNow(Product prod);
    public List<Product> deleteProductById(int id);
}
