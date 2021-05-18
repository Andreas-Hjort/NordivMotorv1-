package com.motorhome.demo.Service;

import com.motorhome.demo.Model.Person;
import com.motorhome.demo.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Person> fetchALL(){
        return customerRepo.fetchALL();
    }

}
