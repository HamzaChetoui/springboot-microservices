package com.microservice.store.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/buy")
public class StoreController {


    @Value("${compute.url}")
    String url;
	//="http://localhost:8008/compute/multiple";

    RestTemplate restTemplate = new RestTemplate();

    Map<Long,Double> productMap = new HashMap<Long,Double>();
    {
        productMap.put(1L,4D);
        productMap.put(2L,5D);
        productMap.put(3L,2D);
    }

    @GetMapping("/{id}")
    public String buy(@PathVariable Long id, @RequestParam int number){
        double price = productMap.containsKey(id)?productMap.get(id):0d;
        Logger logger = LoggerFactory.getLogger(StoreController.class);
        logger.info("Price: "+price);
        if(price==0)
            return "Le product "+id+" n'existe pas";

        double result = restTemplate.getForObject(url+"?a="+price+"&b="+number, double.class);
        return "It cost "+result+" !";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }
}
