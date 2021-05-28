package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.Contracts;
import com.motorhome.demo.Model.Dropoff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.motorhome.demo.Utilities.DateCalc;

import java.util.List;

@Repository
public class    ContractRepo {

    @Autowired
    JdbcTemplate template;

    public List<Contracts> fetchALL(){
        String sql = "SELECT contracts.id_contracts, cars.brand, cars.model, cars.type_cars, cars.odometer, customer.first_name, customer.last_name, \n" +
                "contracts.date_of_reserve, contracts.date_of_handin, \n" +
                "contracts.price, dropoff.address, \n" +
                "dropoff.zip, dropoff.distance_in_kilometer, ekstras.extratype \n" +
                "FROM motorhome.contracts\n" +
                "INNER JOIN motorhome.cars ON cars.id_cars = contracts.idcar INNER JOIN motorhome.customer ON customer.id_customer  = contracts.idcustomer\n" +
                "INNER JOIN motorhome.ekstras ON ekstras.idekstras = contracts.idekstra INNER JOIN motorhome.dropoff ON contracts.idpickup = dropoff.id_dropoff";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        return template.query(sql, rowMapper);
    }

    public void addContract(Contracts c){
        String sql = "INSERT INTO motorhome.contracts VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String start_date = DateCalc.fixDateFormatting(c.getDate_of_Reserve());
        String end_date = DateCalc.fixDateFormatting(c.getDate_of_handIn());
        String season = calculateSeason(c.getDate_of_Reserve());


        template.update(sql,c.getId_contracts(), c.getIDcar(), c.getIDcustomer(), start_date,
               end_date
                ,c.getEnd_kilometer(), season, c.getIDPickUp(), c.getIDekstra());
    }

    public Boolean deleteContract(int id){
        String sql = "DELETE FROM motorhome.contracts WHERE id_contracts = ?";
        return template.update(sql, id) > 0;
    }

    public void createContract(int id){
        String sql = "INSERT INTO motorhome.contracts (idcar) SELECT id FROM motorhome.cars WHERE id_contracts = " + id;
        template.update(sql);
    }

    public Contracts findContractByID(int id){
        String sqlFindContract = "SELECT * FROM motorhome.contracts WHERE id_contracts = ?";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        Contracts contracts = template.queryForObject(sqlFindContract, rowMapper, id);
        return contracts;
    }

    public void updateContract(int id, Contracts input) {
        String sql = "UPDATE motorhome.Contract SET date_of_reserve = ?, date_of_handin WHERE id_contracts = ?";
        template.update(sql, input.getDate_of_Reserve(), input.getDate_of_handIn()  ,id);

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


    public int createddropoffpoint(Dropoff dropoff){
        String sql = "INSERT INTO motorhome.dropoff VALUES (?, ? , ?, ?)";
        template.update(sql ,dropoff.getId_dropoff(), dropoff.getAddress(), dropoff.getZip() , dropoff.getDistance_in_kilometer());
        return dropoff.getId_dropoff();
    }

}
