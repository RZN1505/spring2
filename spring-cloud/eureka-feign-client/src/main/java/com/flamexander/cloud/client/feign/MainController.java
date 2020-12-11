package com.flamexander.cloud.client.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private MainClient mainClient;

    @Autowired
    public void setClient(MainClient mainClient) {

        this.mainClient = mainClient;
    }

    @RequestMapping("/get-client")
    public String getClient(Model model) {
        String answer = mainClient.mainText();
         answer = mainClient.parametrized("200");
        model.addAttribute("main", answer);
        return "main";
    }
}
