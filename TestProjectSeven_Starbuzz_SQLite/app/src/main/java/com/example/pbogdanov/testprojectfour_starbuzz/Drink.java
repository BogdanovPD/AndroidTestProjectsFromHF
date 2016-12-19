package com.example.pbogdanov.testprojectfour_starbuzz;

/**
 * Created by p.bogdanov on 12.12.2016.
 */

public class Drink {
    String name;
    String description;
    int imageResourceId;

    public static final Drink[] drinks = {
            new Drink("Latte", "A couple of espresso shots with steamed milk.", R.drawable.latte),
            new Drink("Cappuccino", "Espresso, hot milk abd a steamed milk foam.", R.drawable.cappuccino),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh.", R.drawable.filter)
    };

    public Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
