package com.example.proyectoinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

        public class Login extends AppCompatActivity {



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);


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
