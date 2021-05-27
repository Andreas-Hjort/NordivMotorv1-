package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.Contracts;
import com.motorhome.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.motorhome.demo.Utilities.DateCalc;

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

    public void addContract(Contracts c){
        String sql = "INSERT INTO motorhome.contracts (0, ?, ?, ?, ?, ?, ?, ?, ?";
        String start_date = DateCalc.fixDateFormatting(c.getDate_of_Reserve());
        String end_date = DateCalc.fixDateFormatting(c.getDate_of_handIn());
        String season = calculateSeason(c.getDate_of_Reserve());


        template.update(sql, c.getId(), c.getIDcar(), c.getIDcustomer(), start_date,
               end_date,
                c.getEnd_kilometer(), season, c.getIDPickUp(), c.getIDekstra());
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

    public String calculateSeason(String date) {
        int month = Integer.parseInt(date.substring(5, 7));
        switch(month) {
            case 12:
            case 1:
            case 2:
                return "Lavsæson";
            case 3:
            case 4:
            case 5:
            case 9:
            case 10:
            case 11:
                return "Mellemsæson";
            case 6:
            case 7:
            case 8:
                return "Højsæson";
            default:
                break;
        }
        return "undefined";
    }

}
