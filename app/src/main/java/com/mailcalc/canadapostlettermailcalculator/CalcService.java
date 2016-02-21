package com.mailcalc.canadapostlettermailcalculator;

/**
 * Created by Maxy on 2016-02-18.
 */
public class CalcService {
    public double calc(int weight, int length, int width, double thickness, String destination, String typeOfItem) {
        boolean Standard = (weight >= 2 && weight <= 50) && (length >= 140 && length <= 156) && (width >= 90 && width <= 156) && (thickness >= 0.18 && thickness <= 5);
        double result = 0;
        switch(destination) {
            case "Canada":
                if(Standard) {
                    result = calcCanadaStandard(weight, length, width, thickness, typeOfItem);
                } else {
                    result = calcCanadaOther(weight, length, width, thickness, typeOfItem);
                }
                break;
            case "USA":
                break;
            case "International":
                break;
        }
        return result;
    }

    public double calcCanadaStandard(int weight, int length, int width, double thickness, String typeOfItem) {
        if(weight <= 30) {
            if(typeOfItem.equals("Stamp(s)")) {
                return 0.85;
            } else {
                return 0.80;
            }
        } else {
            if(typeOfItem.equals("Stamp(s)")) {
                return 1.20;
            } else {
                return 1.19;
            }
        }
    }

    public double calcCanadaOther(int weight, int length, int width, double thickness, String typeOfItem) {
        if(weight <= 30) {
            if(typeOfItem.equals("Stamp(s)")) {
                return 1.80;
            } else {
                return 1.71;
            }
        } else if(weight <= 200) {
            if(typeOfItem.equals("Stamp(s)")) {
                return 2.95;
            } else {
                return 2.77;
            }
        } else if(weight <= 300) {
            if (typeOfItem.equals("Stamp(s)")) {
                return 4.10;
            } else {
                return 3.89;
            }
        } else if(weight <= 400) {
            if (typeOfItem.equals("Stamp(s)")) {
                return 4.70;
            } else {
                return 4.42;
            }
        } else {
            if (typeOfItem.equals("Stamp(s)")) {
                return 5.05;
            } else {
                return 4.74;
            }
        }
    }
}
