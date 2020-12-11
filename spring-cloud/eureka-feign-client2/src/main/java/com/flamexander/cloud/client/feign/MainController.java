package com.flamexander.cloud.client.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private MainClientTwo mainClientTwo;

    @Autowired
    public void setClient(
                          MainClientTwo mainClientTwo) {

        this.mainClientTwo = mainClientTwo;
    }

    @RequestMapping("/get-clienttwo")
    public String getClient(Model model) {
        String answerTwo = mainClientTwo.mainTextTwo();
        answerTwo = mainClientTwo.parametrizedTwo("500");
       model.addAttribute("maintwo", answerTwo);
        return "main";
    }
}
