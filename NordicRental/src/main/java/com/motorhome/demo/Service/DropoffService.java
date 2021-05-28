package com.motorhome.demo.Service;

import com.motorhome.demo.Model.Dropoff;
import com.motorhome.demo.Repository.DropOffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DropoffService {

    @Autowired
    DropOffRepo dropOffRepo;

    public List<Dropoff> fetchALL(){
        return dropOffRepo.fetchall();
    }

    public void createDropOff(Dropoff dropoff){
        dropOffRepo.createddropoffpoint(dropoff);
    }
}
