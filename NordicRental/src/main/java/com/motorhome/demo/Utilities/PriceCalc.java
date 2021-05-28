package com.motorhome.demo.Utilities;
import com.motorhome.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PriceCalc {

    Cars cars = new Cars();
    Ekstras ekstras = new Ekstras();
    Contracts contracts = new Contracts();

    @Autowired
    JdbcTemplate template;

    public int carPrice() {
    String sql = "SELECT price FROM motorhome.cars WHERE motorhome.cars.id = ?";
    return template.update(sql);
    }
    public int ekstrasPrice(){
        String sql = "SELECT price FROM motorhome.ekstras WHERE motorhome.ekstras.idekstras = ?";
        return template.update(sql);
    }
    public int totalPrice() {
        return ekstrasPrice() + carPrice();
    }
    public int priceDatabase(int c){
        String sql = "Update motorhome.contracts SET price = ? WHERE id = ?";
        return template.update(sql, totalPrice(), c);

    }
}
