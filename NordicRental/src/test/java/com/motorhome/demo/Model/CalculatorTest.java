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

        cars.setPrice_cars(20);
        ekstras.setPrice_extras(20);
        contracts.setEnd_kilometer(8000); //2200 miles driven allowed miles 2000
        contracts.setOdometer(5800);
        contracts.setFuel(true);
        contracts.setDate_of_handIn("2020/06/17"); //five days
        contracts.setDate_of_Reserve("2020/06/12");
        contracts.setDistance_in_kilometer(200);
    }

    @Test
    void rentalTotalPricing() {
    }

    @Test
    void contractEndingPrice() {
    }

    @Test
    void contractCancelationFee() {
    }

    @Test
    void calculateSeason() {
    }
}