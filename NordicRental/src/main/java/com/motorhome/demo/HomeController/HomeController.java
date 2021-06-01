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

    /**
     * @author Daniel Benjamin Jones
     * @return
     */

    @GetMapping("/")
    public String frontpage() {
        return "home/index";
    }

    @GetMapping("/create")
    public String create() {
        return ("home/createCustomer");
    }
    //___________________________________________________________________________________-____________________________

    /**
     * writes data to an object
     * @param p
     * @return
     * @Author Andreas Hjort
     */

    @PostMapping("/submitCustomer")
    public String create(@ModelAttribute Person p) {
        customerService.addPerson(p);
        return "redirect:/showCustomer";
    }

    /**
     * Shows a list of customers
     * @param model
     * @return
     * @Author Andreas Hjort
     */

    @GetMapping("/showCustomer")
    public String index(Model model) {
        List<Person> customerlist = customerService.fetchALL();
        model.addAttribute("customers", customerlist);
        return "home/showCustomer";
    }

    /**
     * @Author Axel Gundelach
     * @param id
     * @return
     */

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.delete(id);
        return "redirect:/showCustomer";
    }


//___________________________________________________CARS_____________________________________________________


    /**
     * @Author Viktor Prieme
     * @param model
     * @param c
     * @return
     */
    @GetMapping("/showCars")
    public String carIndex(Model model, Contracts c) {
        List<Cars> carsList = carService.fetchALL();
        model.addAttribute("carslist", carsList);
        return "home/showCars";
    }

    /**Change the bolean cleaning to either true or false
     * @Author Andreas Hjort
     * @param id
     * @return
     */
    @GetMapping("/cleaning/{id}")
    public String changeCleaning(@PathVariable("id") int id) {
        carService.Cleaning(id);
        return "redirect:/showCars";
    }

    /**Adds a car to an obejct from user input
     * @Author Viktor Prieme
     * @param c
     * @return
     */
    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Cars c){
        carService.addCar(c);
        return "redirect:/showCars";
    }

    /** Changes the boolean service to either true or false
     * @Author Andreas Hjort
     * @param id
     * @return
     */

    @GetMapping("/service/{id}")
    public String changeService(@PathVariable("id") int id){
        carService.Service(id);
        return "redirect:/showCars";
    }

//____________________________________________________Contracts__________________________________________________________

    /**
     * Shows the contract object in a list
     * @Author Andreas Hjort
     * @param model
     * @return
     */

    @GetMapping("/showContracts")
    public String contractsIndex(Model model) {
        List<Contracts> contractList = contractService.fetchALL();
        model.addAttribute("contractlist", contractList);
        return "home/showContracts";
    }

    /**
     * Deletes a contract from the database, by finding the specific id.
     * Furthermore the method changes the status of a car to false so i can be rented again
     * @Author Vikor Prieme
     * @param id
     * @return
     */

    @GetMapping("/deleteContract/{id}")
    public String deleteContract(@PathVariable("id") int id) {
        Contracts contracts = contractService.findcontractById(id);
        carService.Status(contracts.getIDcar());
        contractService.deleteContract(id);
        return "redirect:/showContracts";
    }

    /**
     * Gives all the necessary values so they can be shown in an html file
     * @Author Axel Gundelach
     * @param model
     * @return
     */
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

    /**
     * Creates a new dropoff point to choose from
     * @Author Daniel Benjamin Jones
     * @param dropoff
     * @return
     */

    @PostMapping("/dropoff/create")
        public String createContract(@ModelAttribute Dropoff dropoff){
            dropoffService.createDropOff(dropoff);
            return "redirect:/reserveCar";
        }

    /**
     * Method that adds a new contract to an object an later in to the database.
     * Furthermore the status og the car is change to true so it cant be reserved while in a contract
     * @Author Andreas Hjort
      * @param contracts
     * @param model
     * @return
     */
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

    /**
     * @author Daniel Benjamin Jones
     * @param id
     * @param c
     * @return
     */
    @PostMapping("/changedate/'+{contractID}")
    public String changedate(@PathVariable("ID") int id, @ModelAttribute Contracts c){
        contractService.updateContract(id, c);
        return "redirect:/showContracts";
    }

    /**
     * Finds a specifik contracts id and makes the values accessible
     * @Author Axel Gundelach
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/chooseContract/{id}")
    public String chooseContract(@PathVariable("id") int id, Model model) {
        Contracts contracts = contractService.findcontractById(id);
        model.addAttribute("contracts", contracts);
        return "home/endKilometerContract";
    }

    /**
     * Updates the end_kilometer
     *  @Author Andreas Hjort
     * @param id
     * @param c
     * @return
     */

    @PostMapping("/chooseContract/{id}")
    public String chooseContract(@PathVariable("id") int id, @ModelAttribute Contracts c){
        contractService.updatekilometer(id, c);

        return "redirect:/showContracts";
    }

    /**
     * Cancels a contract before the reservation on a id, the price is calacualtede based on how many days before the reservation
     * @Author Viktor Prieme
     * @param id
     * @param model
     * @return
     */

    @GetMapping("/cancelation/{id}")
    public String cancelContract(@PathVariable("id") int id, Model model){
        contractService.cancelationPrice(id);
        Contracts contracts = contractService.findcontractById(id);
        model.addAttribute("contracts", contracts);
        return "home/cancelContracts";
    }


    /**
     * contracts.Fuel is changed to either true or false
     * @Author Andreas Hjort
     * @param id
     * @return
     */
    @GetMapping("/fuel/{id}")
    public String changeFuel(@PathVariable("id") int id){
        contractService.changeFuel(id);
        return "redirect:/showContracts";
    }

    /**
     * Refers to a the endreservation html file with all the desired values
     * @Author Axel Gundelach
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/endReservation/{id}")
    public String Endreservation(@PathVariable("id") int id, Model model){
        Contracts contracts = contractService.findcontractById(id);
        model.addAttribute("contracts", contracts);
        return "home/EndContract";
    }

//______________________________________________________EMPLOYEE_________________________________________________


    /**
     * Shows all the employees in the database
     * @Author Daniel Benjamin Jones
     * @param model
     * @return
     */
    @GetMapping("/showEmployees")
    public String employeeIndex (Model model) {
        List<Employee> employeeList = employeeService.fetchALL();
        model.addAttribute("employees", employeeList);
        return "home/showEmployees";
    }

    /**
     * Adds a new employee
     * @Author Viktor Prieme
     * @param e
     * @return
     */

    @PostMapping("/addEMP")
    public String addEMP(@ModelAttribute Employee e){
        employeeService.addEMP(e);
        return "redirect:/showEmployees";
    }

    /**
     * Deletes an empolyee
     * @author Andreas Hjort
     * @param id
     * @return
     */


    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/showEmployees";
    }

}



