package com.example.pbogdanov.testprojectfour_starbuzz;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        //Drink drink = Drink.drinks[drinkNo];

        SQLiteOpenHelper starBuzzDatabaseHelper = new StarBuzzDatabaseHelper(this);
        SQLiteDatabase db = starBuzzDatabaseHelper.getReadableDatabase();

        try {
            Cursor cursor = db.query("DRINK", new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"}, "_id = ?", new String[]{Integer.toString(drinkNo)}, null, null, null);
            if (cursor.moveToFirst()){
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(cursor.getString(0));

                TextView description = (TextView) findViewById(R.id.description);
                description.setText(cursor.getString(1));

                ImageView imageView = (ImageView) findViewById(R.id.photo);
                imageView.setImageResource(cursor.getInt(2));

                CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
                favorite.setChecked(cursor.getInt(3) == 1);

                cursor.close();
            }
        }
        catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        db.close();
    }

    public void onFavoriteClicked(View view) {
        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_DRINKNO);
        new UpdateDrinkTask().execute(drinkNo);
    }

    private class UpdateDrinkTask extends AsyncTask<Integer, Void, Boolean> {

        ContentValues drinkValues;

        @Override
        protected Boolean doInBackground(Integer... drinks) {
            int drinkNo = drinks[0];
            SQLiteOpenHelper starBuzzDatabaseHelper = new StarBuzzDatabaseHelper(DrinkActivity.this);

            try {
                SQLiteDatabase db = starBuzzDatabaseHelper.getWritableDatabase();
                db.update("DRINK", drinkValues, "_id = ?", new String[]{String.valueOf(drinkNo)});
                db.close();
                return true;
            }
            catch (SQLiteException e){
                return false;
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPreExecute() {
            CheckBox favorite = (CheckBox) findViewById(R.id.favorite);

            drinkValues = new ContentValues();
            drinkValues.put("FAVORITE", favorite.isChecked());
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (!success){
                Toast toast = Toast.makeText(DrinkActivity.this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}
