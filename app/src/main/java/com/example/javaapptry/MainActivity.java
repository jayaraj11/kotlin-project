package com.example.javaapptry;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Submitbtn;
    EditText etFirstname,etEmail;
    RadioGroup Groupbtn;
    CheckBox Checklist;

    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Submitbtn = findViewById(R.id.submitbtn);
        etFirstname = findViewById(R.id.firstname);
        etEmail = findViewById(R.id.email);
        Groupbtn = findViewById(R.id.groupbtn);
        Checklist = findViewById(R.id.checklist);

        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();
                String username = etFirstname.getText().toString();
                String userid = etEmail.getText().toString();


                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("keyname",username);
                intent.putExtra("keyemail",userid);
                if (isAllFieldsChecked) {
//                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
//                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"form is submited",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
        private boolean CheckAllFields() {
        int isSelected = Groupbtn.getCheckedRadioButtonId();


            if (etFirstname.getText().toString().length() == 0) {
                etFirstname.setError("Name is required");
                return false;
            }


            if (etEmail.getText().toString().length() == 0){
                etEmail.setError("Email is required");
                return false;
            }
             if (isSelected ==-1) {
                Toast.makeText(MainActivity.this, "plese select gender", Toast.LENGTH_LONG).show();
                return false;

            }  if (!Checklist.isChecked())
                {
                    Toast.makeText(MainActivity.this,"please check T&C",Toast.LENGTH_LONG).show();
                    return false;
                }



            // after all validation return true.
            return true;


    }
}