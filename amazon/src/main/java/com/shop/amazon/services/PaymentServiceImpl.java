package com.shop.amazon.services;

import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private HashMap<Integer,Integer> payMap;
    public PaymentServiceImpl(){
        payMap = new HashMap<>();
    }
    private Random rand = new Random();
    @Override
    public String paymentResponse(int payment) {
        int key = rand.nextInt(1000);
       
        payMap.put(key, payment);
        System.out.println("Your hashmap payments: \n"+payMap);
        if(payMap.containsValue(payment)){
            return "Payment Success";
        }
        return "Payment Failed";
    }

}
