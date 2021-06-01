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

    @Autowired
    DropoffService dropoffService;

    @GetMapping("/")
    public String frontpage() {
        return "home/index";
    }

    @GetMapping("/showCustomer")
    public String index(Model model) {
        List<Person> customerlist = customerService.fetchALL();
        model.addAttribute("customers", customerlist);
        System.out.println();
        return "home/showCustomer";
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

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.delete(id);
        return "redirect:/showCustomer";
    }


//___________________________________________________CARS_____________________________________________________
    @GetMapping("/showCars")
    public String carIndex(Model model, Contracts c) {
        List<Cars> carsList = carService.fetchALL();
        model.addAttribute("carslist", carsList);
        return "home/showCars";
    }


    @GetMapping("/cleaning/{id}")
    public String changeCleaning(@PathVariable("id") int id) {
        carService.Cleaning(id);
        return "redirect:/showCars";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Cars c){
        carService.addCar(c);
        return "redirect:/showCars";
    }

    @GetMapping("/service/{id}")
    public String changeService(@PathVariable("id") int id){
        carService.Service(id);
        return "redirect:/showCars";
    }

//____________________________________________________Contracts__________________________________________________________

    @GetMapping("/showContracts")
    public String contractsIndex(Model model) {
        List<Contracts> contractList = contractService.fetchALL();
        model.addAttribute("contractlist", contractList);
        return "home/showContracts";
    }

    @GetMapping("/deleteContract/{id}")
    public String deleteContract(@PathVariable("id") int id) {
        Contracts contracts = contractService.findcontractById(id);
        carService.Status(contracts.getIDcar());
        contractService.deleteContract(id);
        return "redirect:/showContracts";
    }


    @GetMapping("/reserveCar")
    public String reserveCar(Model model) {
        List<Cars> cars = carService.fetchALLAvailable();
        List <Person> person = customerService.fetchALL();
        List<Ekstras> ekstra = ekstrasService.fetchAll();
        List<Dropoff> drops = dropoffService.fetchALL();
        model.addAttribute("carslist", cars);
        model.addAttribute(("contracts"), new Contracts());
        model.addAttribute("personlist", person);
        model.addAttribute("ekstraslist", ekstra);
        model.addAttribute("drops", drops);
        return ("home/createContract");
    }

    @PostMapping("/dropoff/create")
        public String createContract(@ModelAttribute Dropoff dropoff){
            dropoffService.createDropOff(dropoff);
            return "redirect:/reserveCar";
        }


   @PostMapping("/reservations/create")
        public String submitContract(Contracts contracts, Model model) {
        List<Cars> cars = carService.fetchALL();
        List<Dropoff> drops = dropoffService.fetchALL();
        model.addAttribute(("contracts"), contracts);
        model.addAttribute("carslist", cars);
        model.addAttribute("drops", drops);
        carService.Status(contracts.getIDcar());
        contractService.addContract(contracts);
        return "redirect:/showContracts";
        }

    @PostMapping("/changedate/'+{contractID}")
    public String changedate(@PathVariable("ID") int id, @ModelAttribute Contracts c){
        contractService.updateContract(id, c);
        return "redirect:/showContracts";
    }


    @GetMapping("/chooseContract/{id}")
    public String chooseContract(@PathVariable("id") int id, Model model) {
        Contracts contracts = contractService.findcontractById(id);
        model.addAttribute("contracts", contracts);
        return "home/endKilometerContract";
    }

    @PostMapping("/chooseContract/{id}")
    public String chooseContract(@PathVariable("id") int id, @ModelAttribute Contracts c){
        contractService.updatekilometer(id, c);

        return "redirect:/showContracts";
    }

    @GetMapping("/cancelation/{id}")
    public String cancelContract(@PathVariable("id") int id, Model model){
        contractService.cancelationPrice(id);
        Contracts contracts = contractService.findcontractById(id);
        model.addAttribute("contracts", contracts);
        return "home/cancelContracts";
    }

    @GetMapping("/fuel/{id}")
    public String changeFuel(@PathVariable("id") int id){
        contractService.changeFuel(id);
        return "redirect:/showContracts";
    }

    @GetMapping("/endReservation/{id}")
    public String Endreservation(@PathVariable("id") int id, Model model){
        Contracts contracts = contractService.findcontractById(id);
        model.addAttribute("contracts", contracts);
        return "home/EndContract";
    }

//______________________________________________________EMPLOYEE_________________________________________________

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



