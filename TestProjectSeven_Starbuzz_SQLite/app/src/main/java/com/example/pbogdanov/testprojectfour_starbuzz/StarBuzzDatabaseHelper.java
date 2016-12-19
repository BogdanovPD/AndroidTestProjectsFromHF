package com.example.pbogdanov.testprojectfour_starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by p.bogdanov on 15.12.2016.
 */

public class StarBuzzDatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "starbuzz";
    private static final int DB_VERSION = 2;

    StarBuzzDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        updateMyDatabase(sqLiteDatabase, i, i1);
    }

    private void updateMyDatabase(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        if (oldVersion < 1){
            sqLiteDatabase.execSQL("CREATE TABLE DRINK(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT, " +
                    "DESCRIPTION TEXT, " +
                    "IMAGE_RESOURCE_ID INTEGER);");

            insertDrink(sqLiteDatabase, "Latte", "A couple of espresso shots with steamed milk.", R.drawable.latte);
            insertDrink(sqLiteDatabase, "Cappuccino", "Espresso, hot milk abd a steamed milk foam.", R.drawable.cappuccino);
            insertDrink(sqLiteDatabase, "Filter", "Highest quality beans roasted and brewed fresh.", R.drawable.filter);
        }
        if (oldVersion < 2){
            sqLiteDatabase.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertDrink(SQLiteDatabase db, String name,
                                    String description, int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }
}
