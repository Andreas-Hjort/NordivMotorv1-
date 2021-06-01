package com.motorhome.demo.Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Calculator {


    public static double rentalTotalPricing(Contracts contracts){
        LocalDate start_date = LocalDate.parse(contracts.getDate_of_Reserve());
        LocalDate end_date = LocalDate.parse(contracts.getDate_of_handIn());
        int days = (int) ChronoUnit.DAYS.between(start_date, end_date);

        double seasonRate = calculateSeason(contracts.getDate_of_Reserve());
        double motorhomePrice = contracts.getCars().getPrice_cars() * days;
        double extraPrice = contracts.getEkstras().getPrice_extras();
        double dropoffPrice = contracts.getDropoff().getDistance_in_kilometer() * 0.70;
        double finalPrice = ((motorhomePrice * seasonRate) + extraPrice + dropoffPrice);

        return finalPrice;
    }

    public static double contractEndingPrice(Contracts contracts){
        LocalDate start_date = LocalDate.parse(contracts.getDate_of_Reserve());
        LocalDate end_date = LocalDate.parse(contracts.getDate_of_handIn());
        int days = (int) ChronoUnit.DAYS.between(start_date, end_date);
        boolean fuel = contracts.getFuel();
        double kilomterdriven = contracts.getEnd_kilometer() - contracts.getOdometer();
        double kilomterPricing = kilomterdriven * 0.7;
        double averagePricing = 0;
        if((days * 400) < kilomterdriven){
            averagePricing = kilomterPricing;
        } if (fuel){
            averagePricing = averagePricing + 70;
        }

       return contracts.getTotal_price() + averagePricing;
    }

    public static double contractCancelationFee(Contracts contracts){
        LocalDate start_date = LocalDate.parse(contracts.getDate_of_Reserve());
        LocalDate cancelationDate = LocalDate.now();
        double total_price = contracts.getTotal_price();
        double finalPrice = 0;

        int days = (int) ChronoUnit.DAYS.between(start_date, cancelationDate);

        if(days < 50){
            double discount20 = total_price * 0.20;
            if(discount20 < 200) {
                finalPrice = 200;
            } else {
                finalPrice = discount20;
            }
        }else if(days <= 49){
           finalPrice = total_price * 0.50;
        }else if(days < 15){
            finalPrice= total_price * 0.80;
        }else if(days == 1){
            finalPrice = total_price * 0.95;
        }
        return finalPrice;
    }

    public static double calculateSeason(String date) {
        int month = Integer.parseInt(date.substring(5, 7));
        switch(month) {
            case 12:
            case 1:
            case 2:
                return 0.50;
            case 3:
            case 4:
            case 5:
            case 9:
            case 10:
            case 11:
                return 0.70;
            case 6:
            case 7:
            case 8:
                return 1;
            default:
                break;
        }
        return 1;
    }
}
