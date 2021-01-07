package com.example.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    ListView listview;
    ArrayList<Hist> arrayList;
    History arrayAdapter;
    Integer num = 1;
    Double solde = 0.0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Started");
        // The following lines just to create our custom adapter for the listView
        listview = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<Hist>();
        arrayAdapter = new History(this, R.layout.list_adapter_view,arrayList);
        listview.setAdapter(arrayAdapter);
    }

    public static boolean isnumber(String number){
        if (number == null){    
            return false;
        }
        try{
            double d = Double.parseDouble(number);
        } catch(NumberFormatException n) {
            return  false;
        }
        return true;
    }


    public void addMoney(View view){
        TextView montantView = (TextView) findViewById(R.id.montantView); //Getting the textView for value of transaction
        String montant = montantView.getText().toString(); // geting the value of the last textView an casting it to string
        TextView msg_err = (TextView) findViewById(R.id.error);
        if (!montant.isEmpty() && isnumber(montant)){
            TextView soldeView = (TextView) findViewById(R.id.soldeView);
            TextView dateView = (TextView) findViewById(R.id.dateView);
            String date = dateView.getText().toString(); //Getting the input date
            dateValidation validator = new dataValidationFormat("dd/MM/yyyy"); //Creating our date format
            dateView.setText(""); // Cleaning the user input for the next transaction
            if (validator.isValid(date)) { //In case the input date is in the right format
//                double temp = solde;
//                solde = solde + Double.parseDouble(montant); // Compute the new value of our Account balance
                if ( solde + Double.parseDouble(montant) < 0){
                    msg_err.setText("solde insufisant");
                } else {
                    solde = solde + Double.parseDouble(montant); // Compute the new value of our Account balance
                    String solde_text = Double.toString(solde); // Parsing the value into Strings
                    soldeView.setText(solde_text); // Showing the new value in the TextView
                    Hist tmp_history = new Hist(num, montant, date); //Creating our object of class History with the number,value and date
                    montantView.setText(""); // Cleaning the user input for the next transaction
                    num++; // Incrementing the number of transaction
                    msg_err.setText(""); // Cleaning the user input for the next transaction
                    arrayList.add(tmp_history); //adding our History object to the array list
                    arrayAdapter.notifyDataSetChanged(); // Update the listView
                }
            }
            else { //Date format is incorrect
                msg_err.setText("Veuillez entrez une date do format MM/dd/yy.");
            }

        }
        else { // Value of transaction is incorrect
            msg_err.setText("Veuillez entrez un montant correcte ");
        }
    }
}