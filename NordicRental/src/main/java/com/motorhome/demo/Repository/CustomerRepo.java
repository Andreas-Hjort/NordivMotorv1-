package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate template;

    public List<Person> fetchALL(){
        String sql = "SELECT * FROM motorhome.customer";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql, rowMapper);
    }

    public Person addCustomer(Person p){
        String sql = "INSERT INTO motorhome.customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, p.getId(), p.getFirst_Name(),p.getLast_Name(), p.getPhone(), p.getMail(), p.getAddress(), p.getZip(), p.getLicensenr(), p.getLicensedate());
        return null;
    }

    public Boolean delete(int id){
        String sql = "DELETE FROM motorhome.customer WHERE id = ?";
        return template.update(sql, id) > 0;
    }
}