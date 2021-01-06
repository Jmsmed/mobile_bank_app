package com.example.mybank;

public class Hist {
    private Integer Num; // Number (Primary Key) of Transaction
    private String Montant; // Value of transaction
    private String Date ; // Date of transaction

    public Hist(Integer num, String montant, String date) { //Constructor of the history classes
        Num = num;
        Montant = montant;
        Date = date;
    }
    // Getters and setters
    public Integer getNum() {
        return Num;
    }

    public void setNum(Integer num) {
        Num = num;
    }

    public String getMontant() {
        return Montant;
    }

    public void setMontant(String montant) {
        Montant = montant;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
