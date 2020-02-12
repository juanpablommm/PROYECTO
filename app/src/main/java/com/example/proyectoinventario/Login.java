package com.example.proyectoinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

        public class Login extends AppCompatActivity {

            Spinner cuentas;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_longui);

                cuentas =(Spinner)findViewById(R.id.cuentas);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.cuentas, android.R.layout.simple_spinner_item);
                cuentas.setAdapter(adapter);
            }

            public void Ingresar(View view) {
                Intent intent=new Intent(this,Menu.class);
                startActivity(intent);
            }


            public void Recuperar_contrasenia(View view) {
                Intent intent=new Intent(this,Recuperar_Contrasenia.class);
                startActivity(intent);
            }
}
