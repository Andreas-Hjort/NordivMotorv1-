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
        String sql = "SELECT * FROM motorhome.contracts";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        return template.query(sql, rowMapper);
    }

    public Contracts addContract(Contracts c){
        String sql = "INSERT INTO motorhome.contracts (idcontracts,idcar, idcustomer, date_of_reserve, date_of_handin, start_kilometer, end_kilometer, price, iddropoff";
        template.update(sql,c.getId(), c.getIDcar(), c.getIDcustomer(), c.getDate_of_Reserve(),
                c.getDate_of_handIn(), c.getStart_kilometer(),
                c.getEnd_kilometer(), c.getPrice(), c.getIDdropOff(), c.getIDPickUp() );
        return null;
    }

    public Boolean deleteContract(int id){
        String sql = "DELETE FROM motorhome.contracts WHERE idcontract = ?";
        return template.update(sql, id) > 0;
    }
}
