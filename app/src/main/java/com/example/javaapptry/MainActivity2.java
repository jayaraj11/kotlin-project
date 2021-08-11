package com.example.javaapptry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView Name,Emailid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Name = findViewById(R.id.name);
        Emailid = findViewById(R.id.emailid);
        String username = getIntent().getStringExtra("keyname");
        String userid = getIntent().getStringExtra("keyemail");
        Name.setText(username);
        Emailid.setText(userid);
    }
}