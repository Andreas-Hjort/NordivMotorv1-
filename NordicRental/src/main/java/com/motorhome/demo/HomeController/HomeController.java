package com.motorhome.demo.HomeController;

import com.motorhome.demo.Model.Cars;
import com.motorhome.demo.Model.Contracts;
import com.motorhome.demo.Model.Person;
import com.motorhome.demo.Service.CarService;
import com.motorhome.demo.Service.ContractService;
import com.motorhome.demo.Service.CustomerService;
import com.motorhome.demo.Service.EkstrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ContractService contractService;

    @Autowired
    CarService carService;

    @Autowired
    EkstrasService ekstrasService;

    @GetMapping("/")
    public String frontpage() {
        return "home/index";
    }

    @GetMapping("/showCustomer")
    public String index(Model model) {
        List<Person> customerlist = customerService.fetchALL();
        model.addAttribute("customers", customerlist);
        return "home/showCustomer";
    }

    @GetMapping("/cleaning/{id}")
    public String changeCleaning(@PathVariable("id") int id) {
        carService.Cleaning(id);
        return "redirect:/showCars";
    }


    @GetMapping("/create")
    public String create() {
        return ("home/createCustomer");
    }

    @PostMapping("/submitCustomer")
    public String create(@ModelAttribute Person p) {
        customerService.addPerson(p);
        return "redirect:/showCustomer";
    }

    @GetMapping("/showCars")
    public String carIndex(Model model, Contracts c) {
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

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.delete(id);
        return "redirect:/showCustomer";
    }


    @GetMapping("/reserveCar/{id}")
    public String addContract(@PathVariable("id") int id) {
        contractService.createContract(id);
        return "home/createContract";
    }

    @GetMapping("/deleteContract/{id}")
    public String deleteContract(@PathVariable("id") int id) {
        contractService.deleteContract(id);
        return "redirect:/showContracts";

    }
    @GetMapping("/service/{id}")
    public String changeService(@PathVariable("id") int id){
        carService.Service(id);
        return "redirect:/showCars";
    }

    @GetMapping("/reserveCar")
    public String reserveCar(Model model) {
        List<Cars> cars =carService.fetchALL();
        List <Person> person = customerService.fetchALL();
        model.addAttribute("carslist", cars);
        model.addAttribute(("contracts"), new Contracts());
        model.addAttribute("personlist", person);
        return ("home/createContract");
    }

    @PostMapping("/submitcontract")
    public String submitContract(Contracts contracts, Model model) {
        List<Cars> cars = carService.fetchALL();
        model.addAttribute(("contracts"), contracts);
        model.addAttribute("carslist", cars);

        contractService.addContract(contracts);
        return "redirect:/showCustomer";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Cars c){
        carService.addCar(c);
        return "redirect:/showCars";
    }

}


