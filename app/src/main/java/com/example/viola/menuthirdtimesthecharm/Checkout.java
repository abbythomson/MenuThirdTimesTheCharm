package com.example.viola.menuthirdtimesthecharm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by viola on 12/1/2016.
 */

public class Checkout extends Activity{
    TextView app;
    TextView ent;
    TextView des;
    TextView total;
    double sum;
    double totalAmount;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);

        app = (TextView) findViewById(R.id.appPrice);
        ent = (TextView) findViewById(R.id.entPrice);
        des = (TextView) findViewById(R.id.desPrice);
        total = (TextView) findViewById(R.id.totalPrice);

        Intent intent = getIntent();
        int appChoice = Integer.parseInt(intent.getStringExtra("App"));
        if(appChoice==0){
            sum = sum+3;
            app.setText("French Fries $3.00");
        }
        else if(appChoice==1){
            sum = sum +3.5;
            app.setText("Cheese Curds $3.50");
        }
        else if(appChoice==2){
            sum = sum+3;
            app.setText("Nachos $3.00");
        }
        else{
            app.setText("None");
        }

        int entChoice = Integer.parseInt(intent.getStringExtra("Entree"));
        if(entChoice==0){
            sum = sum+7;
            app.setText("Burger $7.00");
        }
        else if(entChoice==1){
            sum = sum +6.5;
            app.setText("Sandwitch $6.50");
        }
        else if(entChoice==2){
            sum = sum+6;
            app.setText("Mac N Cheese $6.50");
        }
        else{
            app.setText("None");
        }

        int desChoice = Integer.parseInt(intent.getStringExtra("Dessert"));
        if(desChoice==0){
            sum = sum+3;
            app.setText("Apple Pie $3.00");
        }
        else if(appChoice==1){
            sum = sum +2.5;
            app.setText("Ice Cream $2.50");
        }
        else if(appChoice==2){
            sum = sum+2;
            app.setText("Cookie $2.00");
        }
        else{
            app.setText("None");
        }

        total.setText("$"+sum);
    }
}
