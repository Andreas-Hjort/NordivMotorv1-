package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {

    @Autowired
    JdbcTemplate template;

    public List<Employee> fetchAll(){
        String sql = "SELECT * FROM motorhome.employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public Employee addEmployee(Employee e){
        String sql = "INSERT INTO motorhome.employee VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, e.getId_employee(), e.getFirst_Name(),e.getLast_Name(), e.getPhone(), e.getMail(), e.getOccupation(), e.getAddress(), e.getZip());
        return null;
    }

    public Boolean deleteEmployee(int id){
        String sql = "DELETE FROM motorhome.employee WHERE id_employee = ?";
        return template.update(sql, id) > 0;
    }
}