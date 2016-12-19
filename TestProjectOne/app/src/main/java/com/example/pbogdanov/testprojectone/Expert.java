package com.example.pbogdanov.testprojectone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.bogdanov on 09.12.2016.
 */

public class Expert {
    List<String> getBrands(String color){
        List<String> brands = new ArrayList<String>();

        if (color.equals("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }
        else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}
