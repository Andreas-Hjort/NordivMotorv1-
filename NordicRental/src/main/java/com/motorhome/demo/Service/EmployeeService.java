package com.motorhome.demo.Service;

import com.motorhome.demo.Model.Employee;
import com.motorhome.demo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Andreas Hjort, Daniel Benjamin Jones, Viktor Prieme og Axel Gundelach
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> fetchALL(){
        return employeeRepo.fetchAll();
    }

    public Employee addEMP(Employee e){
        return employeeRepo.addEmployee(e);
    }

    public Boolean deleteEmployee(int id){
        return employeeRepo.deleteEmployee(id);
    }

}