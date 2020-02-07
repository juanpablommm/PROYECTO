package com.example.proyectoinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Login extends AppCompatActivity {

    Spinner Opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Opciones=findViewById(R.id.SpinnerOpciones);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.cuentas,android.R.layout.simple_spinner_item);

        Opciones.setAdapter(adapter);
    }
}
