package com.motorhome.demo.HomeController;

import com.motorhome.demo.Model.Person;
import com.motorhome.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String index(Model model) {
        List<Person> customerlist = customerService.fetchALL();
        model.addAttribute("customers", customerlist);
        return "home/showCustomer";
    }

    @GetMapping("/create")
    public String create(){return ("home/create");}
    @PostMapping
    public String create(@ModelAttribute Person p ){
        customerService.addPerson(p);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        boolean deleted = customerService.deletePerson(id);
        if (deleted){
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }


}