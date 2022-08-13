package com.example.demo.endpoints;

import com.example.demo.services.ProductService;
import com.example.demo.soap.GetProductRequest;
import com.example.demo.soap.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndPoint {

    @Autowired
    private ProductService ps;

    @PayloadRoot(namespace = "demo.example.com/soap", localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProductRequest(@RequestPayload GetProductRequest req) {
        GetProductResponse res = new GetProductResponse();
        res.setProduct(ps.getSingleProduct(req.getName()));

        return res;
    }

}
