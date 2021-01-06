package com.example.mybank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class dataValidationFormat implements dateValidation{
    private String dateFormat;


    public dataValidationFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String date) {
        DateFormat dt = new SimpleDateFormat(this.dateFormat);
        dt.setLenient(false);
        try{
            dt.parse(date);
        } catch(ParseException e){
            return false;
        }
        return true;
    }
}
