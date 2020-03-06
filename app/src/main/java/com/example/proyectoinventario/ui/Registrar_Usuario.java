package com.example.proyectoinventario.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectoinventario.R;
import com.example.proyectoinventario.Recuperar_Contrasenia;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Executor;
import java.util.zip.Inflater;

public class Registrar_Usuario extends Fragment {

        private FirebaseAuth mAuth;

         EditText editTextNombre;
         EditText editTextApellido;
         EditText editTextCedula;
         EditText editTextTelefono;
         EditText editTextCorreo;
         EditText editTextContraseña;
         EditText editTextRol;
         Button btnRegistrar;

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        mAuth = FirebaseAuth.getInstance();


        editTextNombre = view.findViewById(R.id.Nombre_usu);
        editTextApellido = view.findViewById(R.id.Apellido_usu);
        editTextCedula= view.findViewById(R.id.Documento_usu);
        editTextTelefono=view.findViewById(R.id.Telefono_usu);
        editTextCorreo=view.findViewById(R.id.In_correo_usu);
        editTextContraseña=view.findViewById(R.id.In_Contraseña_usu);
        editTextRol=view.findViewById(R.id.In_rol_usu);
        btnRegistrar=view.findViewById(R.id.boton_agregar_usu);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nombre = editTextNombre.getText().toString();
                String Apellido = editTextApellido.getText().toString();
                String Cedula = editTextCedula.getText().toString();
                String Telefono = editTextTelefono.getText().toString();
                String Correo = editTextCorreo.getText().toString();
                String Contraseña = editTextContraseña.getText().toString();
                String Rol = editTextRol.getText().toString();

                //FirebaseAuth
                mAuth.createUserWithEmailAndPassword(Correo, Contraseña)
                        .addOnCompleteListener((Executor) getContext(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(getContext(),"Usuario Creado",Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getContext(),task.getException().toString(),Toast.LENGTH_SHORT).show();


                                }

                            }
                        });

                //FirebaseDatabase
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("usuarios");




                //myRef.child().setValue();


            }
        });
    }

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_registrar__usuario);


        }

    private void setContentView(int fragment_registrar__usuario) {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registrar__usuario,container,false);
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
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getContext(),"Usuario Creado",Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getContext(),task.getException().toString(),Toast.LENGTH_SHORT).show();


                            }

                        }
                    });


        }

    }



