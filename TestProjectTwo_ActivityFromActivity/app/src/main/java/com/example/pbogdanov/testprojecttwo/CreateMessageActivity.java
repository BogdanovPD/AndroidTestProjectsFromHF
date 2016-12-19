package com.example.pbogdanov.testprojecttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view){
        Intent intent =  new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        EditText message = (EditText) findViewById(R.id.message);
        intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
        Intent intentChooser = Intent.createChooser(intent, "Send to...");
        startActivity(intentChooser);
    }
}
