package com.motorhome.demo.HomeController;

import com.motorhome.demo.Model.Cars;
import com.motorhome.demo.Model.Contracts;
import com.motorhome.demo.Model.Person;
import com.motorhome.demo.Service.CarService;
import com.motorhome.demo.Service.ContractService;
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

    @Autowired
    ContractService contractService;

    @Autowired
    CarService carService;

    @GetMapping("/")
    public String frontpage(){
        return "home/index";
    }

    @GetMapping("/showCustomer")
    public String index(Model model) {
        List<Person> customerlist = customerService.fetchALL();
        model.addAttribute("customers", customerlist);
        for (int i = 0; i < customerlist.size(); i ++){
            System.out.println(customerlist.get(i));
        }
        return "home/showCustomer";
    }

    @GetMapping("/create")
    public String create(){return ("home/createCustomer");}
    @PostMapping
    public String create(@ModelAttribute Person p ){
        customerService.addPerson(p);
        return "redirect:/";
    }

    @GetMapping("/showCars")
    public String carIndex(Model model) {
        List<Cars> carsList = carService.fetchALL();
        model.addAttribute("carslist", carsList);
        return "home/showCars";
    }

    @GetMapping("/showContracts")
    public String contractsIndex(Model model) {
        List<Contracts> contractList = contractService.fetchALL();
        model.addAttribute("contractlist", contractList);
        return "home/showContracts";
    }

}