package com.example.proyectoinventario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Recuperar_Contrasenia extends AppCompatActivity {


    private EditText editText_recuperar_contraseña;
    private Button button_recuperar_contraseña;
    private String Correo="";
    private FirebaseAuth Recuperarcontraseña;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar__contrasenia);
        progressDialog=new ProgressDialog(this);
        Recuperarcontraseña=FirebaseAuth.getInstance();
        editText_recuperar_contraseña=(EditText)findViewById(R.id.editText_Recuperar_Contraseña);
        button_recuperar_contraseña=(Button)findViewById(R.id.button_recuperar_Contraseña);


        button_recuperar_contraseña.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Correo=editText_recuperar_contraseña.getText().toString();
                if (!Correo.isEmpty()){
                    progressDialog.setMessage("Espere por favor");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                restablecer_contraseña();
                }
                else
                {
                    Toast.makeText(Recuperar_Contrasenia.this,"Por favor ingrese su correo",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void restablecer_contraseña(){
        Recuperarcontraseña.setLanguageCode("es");
        Recuperarcontraseña.sendPasswordResetEmail(Correo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    Toast.makeText(Recuperar_Contrasenia.this,"La contraseña ha sido enviada al correo por favor revise",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Recuperar_Contrasenia.this,"No se ha podido enviar la contraseña por favor revise que el correo sea correcto",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });

    }


}
