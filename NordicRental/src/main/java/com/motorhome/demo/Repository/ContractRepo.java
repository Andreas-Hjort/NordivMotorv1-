package com.motorhome.demo.Repository;

import com.motorhome.demo.Model.*;
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
        String sql = "SELECT contracts.id_contracts, cars.brand, cars.model, cars.type_cars, cars.odometer, customer.first_name, customer.last_name, \n" +
                "contracts.date_of_reserve, contracts.date_of_handin, \n" +
                "contracts.total_price, dropoff.address, \n" +
                "dropoff.zip, dropoff.distance_in_kilometer, ekstras.extratype, contracts.fuel, contracts.end_kilometer \n" +
                "FROM motorhome.contracts\n" +
                "INNER JOIN motorhome.cars ON cars.id_cars = contracts.idcar INNER JOIN motorhome.customer ON customer.id_customer  = contracts.idcustomer\n" +
                "INNER JOIN motorhome.ekstras ON ekstras.idekstras = contracts.id_ekstra INNER JOIN motorhome.dropoff ON contracts.idpickup = dropoff.id_dropoff";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        return template.query(sql, rowMapper);
    }

    public void addContract(Contracts c){
        String sql = "INSERT INTO motorhome.contracts VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String start_date = c.getDate_of_Reserve();
        String end_date = c.getDate_of_handIn();
        int carfk = c.getIDcar();
        int customerfk = c.getIDcustomer();
        int ekstrasfk = c.getID_ekstra();
        String pickupfk = c.getIDPickUp();
        double kilomterdriven = 0;
        boolean fuel = true;

        setCarsbyid(c);
        setextrasid(c);


        double startingPrice = Calculator.rentalTotalPricing(c);

        template.update(sql,c.getId_contracts() ,carfk, customerfk, start_date,
               end_date
                ,kilomterdriven, startingPrice, pickupfk, ekstrasfk, fuel);
    }

    public Boolean deleteContract(int id){
        String sql = "DELETE FROM motorhome.contracts WHERE id_contracts = ?";
        return template.update(sql, id) > 0;
    }


    public Contracts findContractByID(int id){
        String sqlFindContract = "SELECT contracts.id_contracts, cars.brand, cars.model, cars.type_cars, cars.odometer, customer.first_name, customer.last_name, \n" +
                "contracts.date_of_reserve, contracts.date_of_handin, \n" +
                "contracts.total_price, dropoff.address, \n" +
                "dropoff.zip, dropoff.distance_in_kilometer, ekstras.extratype, contracts.end_kilometer, contracts.fuel  \n" +
                "FROM motorhome.contracts\n" +
                "INNER JOIN motorhome.cars ON cars.id_cars = contracts.idcar INNER JOIN motorhome.customer ON customer.id_customer  = contracts.idcustomer\n" +
                "INNER JOIN motorhome.ekstras ON ekstras.idekstras = contracts.id_ekstra INNER JOIN motorhome.dropoff ON contracts.idpickup = dropoff.id_dropoff WHERE id_contracts = ?";
        RowMapper<Contracts> rowMapper = new BeanPropertyRowMapper<>(Contracts.class);
        List<Contracts> contractslist = template.query(sqlFindContract, rowMapper, id);
        Contracts contracts = contractslist.get(0);
        return contracts;
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
        String sql = "UPDATE motorhome.contracts SET end_kilometer = ?  WHERE id_contracts = ?";
        double end_kilometer = input.getEnd_kilometer();
        template.update(sql, end_kilometer,id);
    }

    public boolean changeFuel(int id) {
        String sql = "UPDATE motorhome.contracts SET fuel = NOT fuel WHERE id_contracts = ?";
        return template.update(sql, id) > 0;
    }

    public void changeEndingPriceKilometer(int id, Contracts c ){
        updateKilometer(id, c);
        Contracts contracts = findContractByID(id);
        String sql = "UPDATE motorhome.contracts SET total_price = ? WHERE id_contracts = ?";
        double calc = Calculator.contractEndingPrice(contracts);

        template.update(sql, calc, id);
    }


    public void cancelationPrice(int id){
        String sql = "UPDATE motorhome.contracts SET total_price = ? WHERE id_contracts = ?";
        Contracts contracts = findContractByID(id);
        double endingPrice = Calculator.contractCancelationFee(contracts);
        template.update(sql, endingPrice, id);
    }

}
