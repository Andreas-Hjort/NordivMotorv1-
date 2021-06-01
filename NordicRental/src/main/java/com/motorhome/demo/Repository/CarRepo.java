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

    public List<Cars> fetchALL() {
        String sql = "SELECT * FROM motorhome.cars WHERE status = false";
        RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<>(Cars.class);
        return template.query(sql, rowMapper);
    }

    public Cars addCars(Cars c) {
        String sql = "INSERT INTO motorhome.cars VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getId_cars(), c.getBrand(), c.getType(), c.getModel(), c.getBeds(), c.getOdometer(), c.getPrice_cars(), c.getStatus(), c.getCleaning(), c.getService());
        return null;
    }

    public Boolean deleteCar(int id) {
        String sql = "DELETE FROM motorhome.cars WHERE id_cars = ?";
        return template.update(sql, id) > 0;
    }

    public boolean Cleaning(int id) {
        String sql = "UPDATE motorhome.cars SET cleaning = NOT cleaning WHERE id_cars = ?";
        return template.update(sql, id) > 0;
    }

    public boolean Service(int id) {
        String sql = "UPDATE motorhome.cars SET service = NOT service WHERE id_cars = ?";
        return template.update(sql, id) > 0;
    }

    public boolean Status(int id){
        String sql = "UPDATE motorhome.cars SET status = NOT status WHERE id_cars = ?";
        return template.update(sql,id) > 0;
    }
}
