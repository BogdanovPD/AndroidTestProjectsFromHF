package com.example.pbogdanov.testprojecttwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        TextView textView = (TextView) findViewById(R.id.message);
        textView.setText(getIntent().getStringExtra("message"));
    }
}
