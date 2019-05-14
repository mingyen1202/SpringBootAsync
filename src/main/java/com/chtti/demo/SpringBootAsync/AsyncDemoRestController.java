package com.chtti.demo.SpringBootAsync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncDemoRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncDemoRestController.class);

    @Autowired
    LongJobService service;

    @RequestMapping("/hello")
    public String hello() {
        LOGGER.info("inside hello");
        try {
            service.doLong(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("hello return");
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        LOGGER.info("inside hello 2");
        try {
            service.doLong(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("hello 2 return");
        return "hello 2";
    }

}
