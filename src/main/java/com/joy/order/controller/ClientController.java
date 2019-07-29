package com.joy.order.controller;

import com.joy.order.client.ProductClient;
import com.joy.order.dataobject.CartDTO;
import com.joy.order.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ai Lun on 2019-07-27.
 */
@RestController
@Slf4j
class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductList")
    public String getProductList() {
        System.out.println("getProductList");
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068", "164103465734242707"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        System.out.println("productDecreaseStock");
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022", 2)));
        return "ok";
    }

    /**
     * 使用 feign
     */
    @GetMapping("/getProductMsgFeign")
    public String getProductMsg() {
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    /**
     * 使用 restTemplate
     * @return
     */
    @GetMapping("/getProductMsg")
    public String GetProductMsg() {
        // 1. 第一种方式 (直接使用restTemplate, url 写死)
        //RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
        //log.info("response={}", response);

        // 2. 第二种方式 (利用 loadBalancerClient，通过应用名获取url，然后再使用 restTemplate)
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/msg");
        String response = restTemplate.getForObject(url, String.class);

        System.out.println("getProductMsg");
        // 3. 第三种方式（利用@LoadBalanced，可再 restTemplate 里使用应用名字）
        //String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        //log.info("response={}", response);

        return response;
    }

}
