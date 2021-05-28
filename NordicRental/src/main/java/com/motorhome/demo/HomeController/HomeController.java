package com.motorhome.demo.HomeController;

import com.motorhome.demo.Model.*;
import com.motorhome.demo.Service.*;
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

    @Autowired
    EmployeeService employeeService;

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
        List<Cars> cars = carService.fetchALL();
        List <Person> person = customerService.fetchALL();
        List<Ekstras> ekstra = ekstrasService.fetchAll();
        model.addAttribute("carslist", cars);
        model.addAttribute(("contracts"), new Contracts());
        model.addAttribute("personlist", person);
        model.addAttribute("ekstraslist", ekstra);
        return ("home/createContract");
    }

    @PostMapping("/reservations/create{id}")
    public String submitContract(@PathVariable("id") int id,  Contracts contracts, Model model , Dropoff dropoff) {
        List<Cars> cars = carService.fetchALL();
        model.addAttribute(("contracts"), contracts);
        model.addAttribute("carslist", cars);
        model.addAttribute("dropoff", dropoff);
        contractService.addContract(contracts, id);
        return "redirect:/showCustomer";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Cars c){
        carService.addCar(c);
        return "redirect:/showCars";
    }

    @PostMapping("/changedate/'+{contractID}")
    public String changedate(@PathVariable("ID") int id, @ModelAttribute Contracts c){
        contractService.updateContract(id, c);
        return "redirect:/showContracts";
    }

    @GetMapping("/showEmployees")
    public String employeeIndex (Model model) {
        List<Employee> employeeList = employeeService.fetchALL();
        model.addAttribute("employees", employeeList);
        return "home/showEmployees";
    }

    @PostMapping("/addEMP")
    public String addEMP(@ModelAttribute Employee e){
        employeeService.addEMP(e);
        return "redirect:/showEmployees";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/showEmployees";

    }
}



