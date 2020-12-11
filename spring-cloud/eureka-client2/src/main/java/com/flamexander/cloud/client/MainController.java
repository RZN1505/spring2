package com.flamexander.cloud.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface MainController {
    @RequestMapping("/maintwo")
    String mainTextTwo();

    @GetMapping("/parametrizedtwo/{id}")
    String parametrizedTwo(@PathVariable(value = "id") String id);
}
