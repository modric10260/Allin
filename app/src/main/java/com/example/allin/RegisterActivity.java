package com.example.allin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    TextView birthdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent i=getIntent();

        OnlineShoppingSystem sys=OnlineShoppingSystem.getInstance();
        DbHelper dbHelper=new DbHelper(this);

        EditText username = findViewById(R.id.RegUsername);
        EditText name = findViewById(R.id.RegFullName);
        EditText ssn = findViewById(R.id.RegSSN);
        EditText email = findViewById(R.id.RegEmail);
        EditText pass = findViewById(R.id.RegPassword);
        EditText country = findViewById(R.id.RegCountry);
        EditText City = findViewById(R.id.RegCity);
        EditText street = findViewById(R.id.RegStreet);
        EditText buildingNum = findViewById(R.id.RegBuilding);
        EditText flatNum = findViewById(R.id.RegApartment);
        Button registerButton = findViewById(R.id.Regsubmitbtn);
        Button datebtn=findViewById(R.id.pickdate);
        birthdate=findViewById(R.id.birth_date);

        Intent Choiceintent = getIntent();
        String source = Choiceintent.getStringExtra("Source");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Person person = PersonFactory.GetPerson("user");}
                User user = new User();

                user.Register(username.getText().toString(),
                            pass.getText().toString(),
                            name.getText().toString(),
                            email.getText().toString(),
                            ssn.getText().toString(),
                            country.getText().toString(),
                            City.getText().toString(),
                            street.getText().toString(),
                            buildingNum.getText().toString(),
                            flatNum.getText().toString(),
                            dbHelper
                );
                Intent intent = new Intent( RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

    }

    private String showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        final String[] date = new String[1];
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        date[0] = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                        birthdate.setText(date[0]);
                    }
                },
                year, month, dayOfMonth
        );

        datePickerDialog.show();

        return date[0];
    }
}