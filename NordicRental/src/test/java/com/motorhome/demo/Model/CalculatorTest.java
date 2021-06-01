package com.motorhome.demo.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Contracts contracts;

    @BeforeEach
    void setup(){
        contracts = new Contracts();
        Cars cars = new Cars();
        Ekstras ekstras = new Ekstras();
        Dropoff dropoff = new Dropoff();

        dropoff.setDistance_in_kilometer(200);
        cars.setPrice_cars(20);
        ekstras.setPrice_extras(20);

        contracts.setCars(cars);
        contracts.setEkstras(ekstras);
        contracts.setDropoff(dropoff);

        contracts.setEnd_kilometer(8000); //2200 miles driven allowed miles 2000
        contracts.setOdometer(5980);
        contracts.setFuel(true);
        contracts.setDate_of_handIn("2020-05-17"); //five days
        contracts.setDate_of_Reserve("2020-05-12");
        contracts.setTotal_price(500);


    }

    @Test
    void rentalTotalPricing() {
        double expectedprice = 230;

        double actualPrice = Calculator.rentalTotalPricing(contracts);

        assertEquals(expectedprice, actualPrice);

    }

    @Test
    void contractEndingPrice() {
        double expectedprice = 1984;
        double actualPrice = Calculator.contractEndingPrice(contracts);
        assertEquals(expectedprice, actualPrice);
    }

}