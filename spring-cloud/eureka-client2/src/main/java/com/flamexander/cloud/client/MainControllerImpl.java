package com.flamexander.cloud.client;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainControllerImpl implements MainController {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

//    @Value("${userValue}")
//    private String username;

    @Override
    @RequestMapping("/maintwo")
    public String mainTextTwo() {
        return String.format("Дополнительная страница", eurekaClient.getApplication(appName).getName());
    }

    @GetMapping("/abc2")
    public void test() {
        System.out.println("_ABC2_");
    }

    @GetMapping("/parametrizedtwo/{id}")
    public String parametrizedTwo(@PathVariable(value = "id") String id) {
        return "нужный ид2: " + id;
    }
}
