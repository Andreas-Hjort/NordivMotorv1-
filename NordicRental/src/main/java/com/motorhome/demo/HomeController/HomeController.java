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

import static java.lang.Integer.parseInt;

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
        return "home/showCustomer";
    }

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

    @PostMapping
    public String carIndex(@ModelAttribute Model model){
      model.addAttribute(carService.Cleaning());
        return "redirect:/";
    }


    @GetMapping("/showContracts")
    public String contractsIndex(Model model) {
        List<Contracts> contractList = contractService.fetchALL();
        model.addAttribute("contractlist", contractList);
        return "home/showContracts";
    }

    @GetMapping("/reserveCar/{id}")
    public String addContract(@PathVariable("id") int id){
        contractService.createContract(id);
     return "home/createContract";
    }

}