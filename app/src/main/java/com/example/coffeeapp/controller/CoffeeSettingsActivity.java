package com.example.coffeeapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.Cart;
import com.example.coffeeapp.model.CoffeeItem;
import com.example.coffeeapp.model.Order;
import com.example.coffeeapp.model.OrderItems;

public class CoffeeSettingsActivity extends AppCompatActivity {

    String coffeeName;
    String milkType;
    String sugarLevel;
    String coffeeStrength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_settings);

        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("Coffee Name")!= null)
        {
            coffeeName = bundle.getString("Coffee Name");
        }

        Spinner milkTypeSpinner = findViewById(R.id.milkTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.MilkType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        milkTypeSpinner.setAdapter(adapter);
        milkTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                milkType = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), milkType, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner sugarLevelSpinner = findViewById(R.id.sugarLevelSpinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.SugarLevel, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sugarLevelSpinner.setAdapter(adapter1);
        sugarLevelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sugarLevel = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), sugarLevel, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner coffeeStrengthSpinner = findViewById(R.id.coffeeStrengthSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.CoffeeStrength, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coffeeStrengthSpinner.setAdapter(adapter2);
        coffeeStrengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                coffeeStrength = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), coffeeStrength, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button coffeeSettingsButton = (Button)findViewById(R.id.coffeeSettingsButton);
        coffeeSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderItems coffeeItem = new OrderItems(coffeeName, milkType + ", " + sugarLevel + ", " + coffeeStrength);
                Cart.getInstance().addCartItemToList(coffeeItem);
                Log.e("instance", Cart.getInstance().getCartItemsArrayList().get(0).getCoffeeSpecifcations());
                Intent intent = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(intent);

            }
        });

    }

}
