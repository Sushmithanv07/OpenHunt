package com.nobroker.controller;

import com.nobroker.entity.Product;
import com.nobroker.repository.ProductRepository;
import com.nobroker.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentService paymentService;

//    @PostMapping("/initiate")
//    public ResponseEntity<String> initiatePayment(@RequestParam long productId){
//
//        Product product = productRepository.findById(productId).orElseThrow(
//                ()-> new EntityNotFoundException("Product not found"));
//                String paymentIntentId = paymentService.createPaymentIntent(product.getPrice());
//
//        return ResponseEntity.ok(paymentIntentId);
//    }
}

