package com.example.pbogdanov.testprojectone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Expert expert = new Expert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFind(View view){
        TextView textView = (TextView) findViewById(R.id.textView);

        Spinner color = (Spinner) findViewById(R.id.color);

        List<String> list = expert.getBrands(String.valueOf(color.getSelectedItem()));

        StringBuilder sb = new StringBuilder();

        for (String listEl:list) {
            sb.append(listEl + "\n");
        }

        textView.setText(sb);

    }

}
