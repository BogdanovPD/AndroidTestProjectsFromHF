package com.example.pbogdanov.testprojectsix_bitsandpizzas_panels;

/**
 * Created by p.bogdanov on 19.12.2016.
 */

public class Pasta {
    private String name;
    private int imageResourceId;

    public static final Pasta[] pastas = {
            new Pasta("Spaghetti Bolognese", R.drawable.spag_bol),
            new Pasta("Lasagne", R.drawable.lasagne)
    };

    public Pasta(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
