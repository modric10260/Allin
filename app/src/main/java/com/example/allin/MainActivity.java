package com.example.allin;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(this);
        dbHelper.insertDummyUserData();
        dbHelper.insertDummyItem();
        dbHelper.insertDummyAdmin();
        OnlineShoppingSystem system = OnlineShoppingSystem.getInstance();
        //system.loadUsersFromDatabase(dbHelper)
        // system.loadItemsFromDatabase(dbHelper);
        system.InitializeAppData(dbHelper);

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}