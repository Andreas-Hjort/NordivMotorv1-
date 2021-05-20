package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {
    @Autowired
    JdbcTemplate template;

    public List<Cars> fetchALL(){
        String sql = "SELECT idcars, brand, model, beds, odometer, status, cleaning, service FROM motorhome.cars";
        RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<>(Cars.class);
        return template.query(sql, rowMapper);
    }
     public Cars addCars(Cars c) {
         String sql = "INSERT INTO idcars, brand, model, beds, odometer, status, cleaning, service FROM motorhome.cars";
         template.update(sql, c.getBeds(), c.getBrand(),c.getCleaning(),c.getId(),c.getModel(),c.getOdometer(),c.getService(),c.getStatus());
         return null;
     }
     public Boolean deleteCar(int id){
         String sql = "DELETE FROM motorhome.cars WHERE idcars = ?";
         return template.update(sql, id) > 0;
     }

}
