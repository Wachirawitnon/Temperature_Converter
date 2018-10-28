package com.example.temperatureconverter.model;

import android.util.Log;

import java.util.Locale;

public class body {
    private double input;
    public body(double input){
        this.input = input;

    }
    public double toFahranheit(){
        // °F = (9/5 × °C) + 32
        double result = (1.8*input)+32;
        return result;

    }
    public double toCelsius(){
        //°C = (F - 32) x 5/9
        double result = (input - 32)* 5/9;
        return result;

    }
    public String checkingDecimalF(double resultcalculate){
        String[] chk = String.valueOf(resultcalculate).split("\\."); //ทำให้กลายเป็น String และแยกส่วนมาเก็บใน arrey
        String output ;
        if(chk[1].substring(0,1).equals("0")){ // (เอา,ไม่เอา);
            output = checkingDecimalInput() + " องศาเซลเซียส \nเท่ากับ\n " + chk[0] + " องศาฟาเรนไฮต์ ";
            return output;


        }
        else {
            output = checkingDecimalInput() + " องศาเซลเซียส \nเท่ากับ\n " + String.format(Locale.US, "%.2f", resultcalculate) + " องศาฟาเรนไฮต์ ";
            return output;

        }

    }

    public String checkingDecimalC(double resultcalculate){
        String[] chk = String.valueOf(resultcalculate).split("\\."); //ทำให้กลายเป็น String และแยกส่วนมาเก็บใน arrey
        String output ;
        if(chk[1].substring(0,1).equals("0")){ // (เอา,ไม่เอา);
            output = checkingDecimalInput() + " องศาฟาเรนไฮต์ \nเท่ากับ\n " + chk[0] + " องศาเซลเซียส ";

            return output;
        }
        else {
            output = checkingDecimalInput() + " องศาฟาเรนไฮต์ \nเท่ากับ\n " + String.format(Locale.US, "%.2f", resultcalculate) + " องศาเซลเซียส ";
            return output;

        }

    }

    public String checkingDecimalInput(){
        String[] chk = String.valueOf(this.input).split("\\."); //ทำให้กลายเป็น String และแยกส่วนมาเก็บใน arrey
        String input;
        if(chk[1].substring(0,1).equals("0")){ // (เอา,ไม่เอา);
            input =  chk[0] ;
            return input;
        }
        else {
            input = String.format(Locale.US, "%.2f",this.input);
            return input;

        }

    }

}
