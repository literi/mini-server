package work.spacestime.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHelloController {

    @Autowired
    private ProducerService ProducerService;
    
    @RequestMapping("/feign/call")
    public String call() {
        // 像调用本地服务一样
        return ProducerService.hello();
    }
    
}