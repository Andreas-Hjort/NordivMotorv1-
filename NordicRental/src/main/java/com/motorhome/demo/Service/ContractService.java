package com.motorhome.demo.Service;

import com.motorhome.demo.Model.*;
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

    public Contracts findcontractById(int id){
        return contractRepo.findContractByID(id);
    }

    public void updateContract(int id, Contracts c){
        contractRepo.updateContract(id, c);
    }

    public void updatekilometer(int id, Contracts c) {contractRepo.changeEndingPriceKilometer(id, c );}

    public void cancelationPrice(int id){
        contractRepo.cancelationPrice(id);
    }

    public void changeFuel(int id){
        contractRepo.changeFuel(id);
    }

    public List<Contracts> findContractByIdList(int id){
        return findContractByIdList(id);
    }


}
