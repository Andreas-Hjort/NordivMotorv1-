package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.Contracts;
import com.motorhome.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepo {

    @Autowired
    JdbcTemplate template;

    public List<Contracts> fetchALL(){
        String sql = "SELECT * FROM motorhome.contracts JOIN motorhome.cars ON cars.id = contracts.idcar JOIN motorhome.customer ON idcustomer = customer.id";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        return template.query(sql, rowMapper);
    }

    public Contracts addContract(Contracts c){
        String sql = "INSERT INTO motorhome.contracts (0, ?, ?, ?, ?, ?, ?, ?, ?";
        template.update(sql, c.getId(), c.getIDcar(), c.getIDcustomer(), c.getDate_of_Reserve(),
                c.getDate_of_handIn(), c.getStart_kilometer(),
                c.getEnd_kilometer(), c.getPrice(), c.getIDdropOff(), c.getIDPickUp() );
        return null;
    }

    public Boolean deleteContract(int id){
        String sql = "DELETE FROM motorhome.contracts WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public void createContract(int id){
        String sql = "INSERT INTO motorhome.contracts (idcar) SELECT id FROM motorhome.cars WHERE id = " + id;
        template.update(sql);
    }

    public Contracts findContractByID(int id){
        String sqlFindContract = "SELECT * FROM motorhome.contracts WHERE id = ?";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        Contracts contracts = template.queryForObject(sqlFindContract, rowMapper, id);
        return contracts;
    }

    public void updateContract(Contracts contracts, int id){

    }
}
