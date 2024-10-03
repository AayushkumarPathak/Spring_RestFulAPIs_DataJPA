package com.shop.amazon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.amazon.entities.Product;
import com.shop.amazon.services.PaymentService;
import com.shop.amazon.services.ProductServices;

@RestController
public class PagesController {

    @Autowired
    private ProductServices productServ;

    @Autowired
    private PaymentService paymentServ;

    @RequestMapping("/home")
    public String Home() {
        return "home page";
    }

    @GetMapping("/products/add")
    public List<Product> getProduct() {
        return productServ.getAllProduct();
    }

    @GetMapping("/products/{prodId}")
    public Product getProduct(@PathVariable String prodId) {
        try{
            int id = Integer.parseInt(prodId);
            Product prod = productServ.getProductById(id);
            if(prod!=null){
                return prod;
            }
            else{
                return null;
            }
        }
        catch(NumberFormatException e){
            e.printStackTrace();
            
        }
        return null;
        // return productServ.getProductById(Integer.parseInt(prodId));
    }

    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product){
        return productServ.addProductNow(product);

    }
    @RequestMapping(path = "/products/delete/{id}",method = RequestMethod.GET)
    public List<Product> deleteProductByID(@PathVariable String id){
        return productServ.deleteProductById(Integer.parseInt(id));
    }

    @GetMapping("/products/payment/{payment}")
    public String payMentResponse(@PathVariable String payment){
        try{
            int rupee = Integer.parseInt(payment);
            return paymentServ.paymentResponse(rupee);

        }
        catch(Exception e){
            return "Payment failed at gateway\nMoney will refunded between 3 to 4 working days";
        }
        // return paymentServ.paymentResponse(Integer.parseInt(payment));
    }
    

}
