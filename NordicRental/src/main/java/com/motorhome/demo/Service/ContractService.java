package com.motorhome.demo.Service;

import com.motorhome.demo.Model.Contracts;
import com.motorhome.demo.Model.Person;
import com.motorhome.demo.Repository.ContractRepo;
import com.motorhome.demo.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {


    @Autowired
    ContractRepo contractRepo;

    public List<Contracts> fetchALL(){
        return contractRepo.fetchALL();
    }

    public void addContract(Contracts c){
        contractRepo.addContract(c);
    }

    public Boolean deleteContract(int id){
        return contractRepo.deleteContract(id);
    }

    public void createContract(int id){
        contractRepo.createContract(id);
    }

    public Contracts findcontractid(int id){
        return contractRepo.findContractByID(id);
    }

}
