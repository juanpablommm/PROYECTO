package com.example.proyectoinventario.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectoinventario.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class Registrar_Usuario extends Fragment {

        private FirebaseAuth mAuth;
         EditText editTextNombre;
         EditText editTextApellido;
         EditText editTextCedula;
         EditText editTextTelefono;
         EditText editTextCorreo;
         EditText editTextContraseña;
         EditText editTextRol;

       @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_registrar__usuario);
            mAuth = FirebaseAuth.getInstance();


            editTextNombre.findViewById(R.id.Nombre_usu);
            editTextApellido.findViewById(R.id.Apellido_usu);
            editTextCedula.findViewById(R.id.Documento_usu);
            editTextTelefono.findViewById(R.id.Telefono_usu);
            editTextCorreo.findViewById(R.id.In_correo_usu);
            editTextContraseña.findViewById(R.id.In_Contraseña_usu);
            editTextRol.findViewById(R.id.In_rol_usu);


        }

    private void setContentView(int fragment_registrar__usuario) {
    }

    @Override
        public void onStart() {
            super.onStart();
            FirebaseUser currentUser = mAuth.getCurrentUser();

        }

        public void saveUser(View view) {

            String email = editTextCorreo.getText().toString();
            String password = editTextContraseña.getText().toString();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                            } else {
                                // If sign in fails, display a message to the user.


                            }

                        }
                    });

        }
    }



