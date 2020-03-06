package com.example.proyectoinventario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private EditText Email;
    private EditText Contraseña;
    private FirebaseAuth mAuth;

    public Login() {
    }


    @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
                inicializarViews();
                // Initialize Firebase Auth
                //mAuth = FirebaseAuth.getInstance();


            }
    private void inicializarViews() {
        Email = findViewById(R.id.CampoUsuario);
        Contraseña = findViewById(R.id.Contraseña);
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

            public void Ingresar(View view) {
                //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                String email = Email.getText().toString();
                String password = Contraseña.getText().toString();

                if(validar()) {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("LOGIN", "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent= new Intent(Login.this, Menu.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("LOGIN", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(Login.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        //updateUI(null);
                                    }

                                    // ...
                                }
                            });
                }else{
                    Toast.makeText(Login.this, "Verifique los datos ingresados",
                            Toast.LENGTH_SHORT).show();
                }


            }
    private boolean validar() {
        if(Email.getText().length() == 0){
            Email.setError("Debe ingresar un correo");
            return false;
        }
        if(Contraseña.getText().length() == 0){
            Contraseña.setError("Debe ingresar un password");
            return false;
        }
        return true;
    }

            public void Recuperar_contrasenia(View view) {
                Intent intent=new Intent(this,Recuperar_Contrasenia.class);
                startActivity(intent);
            }
}
