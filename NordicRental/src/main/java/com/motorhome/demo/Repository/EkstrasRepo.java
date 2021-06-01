package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.Ekstras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;



/**
 * @Author Daniel Jones
 */

@Repository
public class EkstrasRepo {

    @Autowired
    JdbcTemplate template;

    public List<Ekstras> fetchAll(){
        String sql = "SELECT * From motorhome.ekstras";
        RowMapper<Ekstras> rowMapper = new BeanPropertyRowMapper<Ekstras>(Ekstras.class);
        return template.query(sql, rowMapper);
    }


    public Ekstras findEkstrasByID(int id){
        String sql = "SELECT * FROM motorhome.ekstras WHERE idekstras = ?";
        RowMapper<Ekstras> rowMapper = new BeanPropertyRowMapper<>(Ekstras.class);
        Ekstras e = template.queryForObject(sql, rowMapper, id);
        return e;
    }

}
