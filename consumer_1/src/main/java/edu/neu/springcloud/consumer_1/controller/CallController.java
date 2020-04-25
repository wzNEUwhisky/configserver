package edu.neu.springcloud.consumer_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class CallController {

    //private final static String PROVIDER_URL = "http://localhost:8003/";
    private final static String PROVIDER_URL = "http://provider/";
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/findAll")
    public Object findAll(){
        return restTemplate.getForObject(PROVIDER_URL+"user/findAll",Object.class);
    }

    @RequestMapping("/add/{code}")
    public Object add(@PathVariable String code){
        return restTemplate.getForObject(PROVIDER_URL+"user/add/" + code ,Object.class);
    }

    @RequestMapping("/delete/{code}")
    public Object delete(@PathVariable String code){
        return restTemplate.getForObject(PROVIDER_URL+"user/delete/" + code ,Object.class);
    }

    @RequestMapping("/change/{code}")
    public Object change(@PathVariable String code){
        return restTemplate.getForObject(PROVIDER_URL+"user/change/" + code ,Object.class);
    }

    @RequestMapping("/findById/{code}")
    public Object findById(@PathVariable String code){
        return restTemplate.getForObject(PROVIDER_URL+"user/findById/" + code ,Object.class);
    }

    @RequestMapping("/findByName/{code}")
    public Object findByName(@PathVariable String code){
        return restTemplate.getForObject(PROVIDER_URL+"user/findByName/" + code ,Object.class);
    }

    @RequestMapping("/findByIdAndName/{code}")
    public Object findByIdAndName(@PathVariable String code){
        return restTemplate.getForObject(PROVIDER_URL+"user/findByIdAndName/" + code ,Object.class);
    }

}
