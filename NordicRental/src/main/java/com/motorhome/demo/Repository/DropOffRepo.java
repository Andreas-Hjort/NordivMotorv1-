package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.Contracts;
import com.motorhome.demo.Model.Dropoff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Andreas Hjort
 */
@Repository
public class DropOffRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public void createddropoffpoint(Dropoff dropoff){
        String sql = "INSERT INTO motorhome.dropoff VALUES (?, ?, ? , ?)";
        jdbcTemplate.update(sql ,dropoff.getId_dropoff(), dropoff.getAddress(), dropoff.getZip(), dropoff.getDistance_in_kilometer());
    }

    public List<Dropoff> fetchall(){
        String sql = "SELECT * FROM motorhome.dropoff";
        RowMapper<Dropoff> rowMapper = new BeanPropertyRowMapper<>(Dropoff.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
}
