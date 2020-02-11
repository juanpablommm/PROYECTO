package com.example.proyectoinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Longui extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longui);
    }

    public void Ingresar(View view) {
        Intent intent=new Intent(this,Menu.class);
        startActivity(intent);
    }
}
