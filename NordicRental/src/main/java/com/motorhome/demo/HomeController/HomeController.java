package com.motorhome.demo.HomeController;

import com.motorhome.demo.Model.Person;
import com.motorhome.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String index(Model model) {
        List<Person> customerlist = customerService.fetchALL();
        model.addAttribute("customers", customerlist);
        return "home/index";
    }
}