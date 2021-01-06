package com.example.mybank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class History extends ArrayAdapter<Hist> {
    private static final String TAG = "HistoryListAdapter";
    private Context Context;
    private ArrayList<Hist> history;
    private int Resource;


    public History(@NonNull Context context, int resource, @NonNull ArrayList<Hist> objects) { //The constructor of our adapter with our context and ressources
        super(context, resource, objects);
        this.Context = context;
        Resource = resource;
        this.history = objects;
    }

    @Override
    public int getCount() {
        return history.size();
    }



    @Nullable
    @Override
    public Hist getItem(int position) {
        return history.get(position);
    } //Return the item in the giving position

    @Override
    public int getPosition(@Nullable Hist item) {
        return history.indexOf(item);
    } //To get the position of certain item

    @Override
    public long getItemId(int position) {
        return position;
    } //get position by itemID

    public View getView(int position, View convertView, ViewGroup parents){ //Get the view in a given position

        if ( convertView == null) {
            convertView = LayoutInflater.from(Context).inflate(Resource,parents,false);
            // Inflate our layer from the custom context and using our ressources
        }

        TextView Num = (TextView) convertView.findViewById(R.id.textNum); //For the labels in our application
        TextView montant = (TextView) convertView.findViewById(R.id.textMontant);
        TextView Date = (TextView) convertView.findViewById(R.id.textDate);
        Num.setText(getItem(position).getNum().toString());
        montant.setText(getItem(position).getMontant());
        Date.setText(getItem(position).getDate());

        return convertView;
    }
}
