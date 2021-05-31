package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.*;
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
        String sql = "SELECT contracts.id_contracts, cars.brand, cars.model, cars.type_cars, cars.odometer, customer.first_name, customer.last_name, \n" +
                "contracts.date_of_reserve, contracts.date_of_handin, \n" +
                "contracts.total_price, dropoff.address, \n" +
                "dropoff.zip, dropoff.distance_in_kilometer, ekstras.extratype \n" +
                "FROM motorhome.contracts\n" +
                "INNER JOIN motorhome.cars ON cars.id_cars = contracts.idcar INNER JOIN motorhome.customer ON customer.id_customer  = contracts.idcustomer\n" +
                "INNER JOIN motorhome.ekstras ON ekstras.idekstras = contracts.id_ekstra INNER JOIN motorhome.dropoff ON contracts.idpickup = dropoff.id_dropoff";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        return template.query(sql, rowMapper);
    }

    public void addContract(Contracts c){
        String sql = "INSERT INTO motorhome.contracts VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String start_date = c.getDate_of_Reserve();
        String end_date = c.getDate_of_handIn();
        int carfk = c.getIDcar();
        int customerfk = c.getIDcustomer();
        int ekstrasfk = c.getID_ekstra();
        String pickupfk = c.getIDPickUp();
        double kilomterdriven = 0;
        setCarsbyid(c);
        setextrasid(c);


        double startingPrice = Calculator.rentalTotalPricing(c);

        template.update(sql,c.getId_contracts() ,carfk, customerfk, start_date,
               end_date
                ,kilomterdriven, startingPrice, pickupfk, ekstrasfk);
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
        String sqlFindContract = "SELECT contracts.id_contracts, cars.brand, cars.model, cars.type_cars, cars.odometer, customer.first_name, customer.last_name, \n" +
                "contracts.date_of_reserve, contracts.date_of_handin, \n" +
                "contracts.total_price, dropoff.address, \n" +
                "dropoff.zip, dropoff.distance_in_kilometer, ekstras.extratype, contracts.end_kilometer  \n" +
                "FROM motorhome.contracts\n" +
                "INNER JOIN motorhome.cars ON cars.id_cars = contracts.idcar INNER JOIN motorhome.customer ON customer.id_customer  = contracts.idcustomer\n" +
                "INNER JOIN motorhome.ekstras ON ekstras.idekstras = contracts.id_ekstra INNER JOIN motorhome.dropoff ON contracts.idpickup = dropoff.id_dropoff WHERE id_contracts = ?";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        List<Contracts> contractslist = template.query(sqlFindContract, rowMapper, id);
        Contracts contracts = contractslist.get(0);
        return contracts;
    }

    public List<Contracts> findContractByIDList(int id){
        String sqlFindContract = "SELECT contracts.id_contracts, cars.brand, cars.model, cars.type_cars, cars.odometer, customer.first_name, customer.last_name, \n" +
                "contracts.date_of_reserve, contracts.date_of_handin, \n" +
                "contracts.total_price, dropoff.address, \n" +
                "dropoff.zip, dropoff.distance_in_kilometer, ekstras.extratype, contracts.end_kilometer  \n" +
                "FROM motorhome.contracts\n" +
                "INNER JOIN motorhome.cars ON cars.id_cars = contracts.idcar INNER JOIN motorhome.customer ON customer.id_customer  = contracts.idcustomer\n" +
                "INNER JOIN motorhome.ekstras ON ekstras.idekstras = contracts.id_ekstra INNER JOIN motorhome.dropoff ON contracts.idpickup = dropoff.id_dropoff WHERE id_contracts = ?";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        List<Contracts> contractslist = template.query(sqlFindContract, rowMapper, id);
        return contractslist;
    }



    public void setCarsbyid(Contracts c){
        String sql =  "SELECT id_cars, brand, type_cars, model, odometer, price_cars FROM motorhome.cars Where id_cars = ?";

        RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<>(Cars.class);
         List<Cars> carsList = template.query(sql, rowMapper, c.getIDcar());
         c.setCars(carsList.get(0));
    }

    public void setextrasid(Contracts c){
        String sql =  "SELECT idekstras, extratype, price_extras FROM motorhome.ekstras Where idekstras = ?";

        RowMapper<Ekstras> rowMapper = new BeanPropertyRowMapper<>(Ekstras.class);
        List<Ekstras> ekstrasList = template.query(sql, rowMapper, c.getIDcar());
        c.setEkstras(ekstrasList.get(0));
    }

    public void updateContract(int id, Contracts input) {
        String sql = "UPDATE motorhome.Contract SET date_of_reserve = ?, date_of_handin WHERE id_contracts = ?";
        template.update(sql, input.getDate_of_Reserve(), input.getDate_of_handIn()  ,id);

    }

    public void updateKilometer(int id, Contracts input) {

        String sql = "UPDATE motorhome.contracts SET end_kilometer = ? total_price = ? WHERE id_contracts = ?";
        Contracts contracts = findContractByID(id);
        setextrasid(contracts);
        setCarsbyid(contracts);

        double end_kilometer = input.getEnd_kilometer();
        double endingprice = Calculator.contractEndingPrice(contracts);

        template.update(sql, end_kilometer, endingprice,id);
    }


    public int createddropoffpoint(Dropoff dropoff){
        String sql = "INSERT INTO motorhome.dropoff VALUES (?, ? , ?, ?)";
        template.update(sql ,dropoff.getId_dropoff(), dropoff.getAddress(), dropoff.getZip() , dropoff.getDistance_in_kilometer());
        return dropoff.getId_dropoff();
    }


}
