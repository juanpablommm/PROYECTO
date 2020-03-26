package com.example.proyectoinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Muestras extends AppCompatActivity {

    private TextView textViewnombre;
    TextView textViewapellido;
    TextView textViewtelefono;
    TextView textViewcedula;
    TextView textViewcorreo;
    TextView textViewcontraseña;
    TextView textViewrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestras);

        inicializarView();
        Bundle bundle = getIntent().getExtras();
        textViewnombre.setText(bundle.getString("nombres"));
        textViewapellido.setText(bundle.getString("apellidos"));
        textViewtelefono.setText(bundle.getString("telefono"));
        textViewcedula.setText(bundle.getString("cedula"));
        textViewcorreo.setText(bundle.getString("correo"));
        textViewcontraseña.setText(bundle.getString("contraseña"));
        textViewrol.setText(bundle.getString("rol"));


    }
    private void inicializarView(){
        textViewnombre= findViewById(R.id.textViewnombreConsultar);

        textViewapellido=findViewById(R.id.textViapellidoConsultar);
        textViewtelefono=findViewById(R.id.textViatelefonoConsultar);
        textViewcedula=findViewById(R.id.textVicedulaConsultar);
        textViewcorreo=findViewById(R.id.textCorreoConsultar);
        textViewcontraseña=findViewById(R.id.textVicontraseñaConsultar);
        textViewrol=findViewById(R.id.textVirolConsultar);

    }
}

