package com.example.pbogdanov.testprojectfour_starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];

        ImageView imageView = (ImageView) findViewById(R.id.photo);
        imageView.setImageResource(drink.getImageResourceId());

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(drink.getName());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(drink.getDescription());
    }
}
