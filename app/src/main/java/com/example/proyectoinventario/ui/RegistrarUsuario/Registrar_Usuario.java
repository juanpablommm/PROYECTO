package com.example.proyectoinventario.ui.RegistrarUsuario;

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
import com.example.proyectoinventario.ui.ClasesJava.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;
import java.util.concurrent.Executor;

public class Registrar_Usuario extends Fragment {

        private FirebaseAuth mAuth;

        private EditText editTextNombre;
        private EditText editTextApellido;
        private EditText editTextCedula;
        private EditText editTextTelefono;
        private EditText editTextCorreo;
        private EditText editTextContrasena;
        private EditText editTextRol;
        private Button btnRegistrar;

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        mAuth = FirebaseAuth.getInstance();


        editTextNombre = view.findViewById(R.id.Nombre_usuario);
        editTextApellido = view.findViewById(R.id.Apellido_usu);
        editTextCedula= view.findViewById(R.id.Documento_usu);
        editTextTelefono=view.findViewById(R.id.Telefono_usu);
        editTextCorreo=view.findViewById(R.id.In_correo_usuario);
        editTextContrasena=view.findViewById(R.id.In_Contraseña_usu);
        editTextRol=view.findViewById(R.id.In_rol_usu);
        btnRegistrar=view.findViewById(R.id.boton_agregar_usu);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuarios usuarios = new Usuarios();
                usuarios.setNombre_Usuario(editTextNombre.getText().toString());
                usuarios.setApellido_Usuario(editTextApellido.getText().toString());
                usuarios.setCedula_Usuario(editTextCedula.getText().toString());
                usuarios.setTelefono_Usuario(editTextTelefono.getText().toString());
                usuarios.setCorreo_Usuario(editTextCorreo.getText().toString());
                usuarios.setContrasena_Usuario(editTextContrasena.getText().toString());
                usuarios.setRol_Usuario(editTextRol.getText().toString());
                usuarios.setIdUsuario(UUID.randomUUID().toString());

                //FirebaseAuth

                mAuth.createUserWithEmailAndPassword(usuarios.getCorreo_Usuario(), usuarios.getContrasena_Usuario())
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(view.getContext(), "usuario credo",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(view.getContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                //FirebaseDatabase
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Usuarios");




                myRef.child(usuarios.getIdUsuario()).setValue(usuarios);


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
            String password = editTextContrasena.getText().toString();

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

