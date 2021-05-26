package com.motorhome.demo.Service;

import com.motorhome.demo.Model.Ekstras;
import com.motorhome.demo.Repository.EkstrasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EkstrasService {

    @Autowired
    EkstrasRepo ekstrasRepo;

    public List<Ekstras> fetchAll() {
        return ekstrasRepo.fetchAll();
    }

    public Ekstras findEkstrasByID(int id) {
        return ekstrasRepo.findEkstrasByID(id);
    }
}
