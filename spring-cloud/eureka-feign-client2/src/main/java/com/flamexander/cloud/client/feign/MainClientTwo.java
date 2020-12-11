package com.flamexander.cloud.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-client2")
public interface MainClientTwo {
    @RequestMapping("/maintwo")
    String mainTextTwo();

    @GetMapping("/parametrizedtwo/{id}")
    String parametrizedTwo(@PathVariable(value = "id") String id);
}
