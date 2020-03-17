package com.example.proyectoinventario.ui.RegistrarAmbiente;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectoinventario.R;
import com.example.proyectoinventario.ui.ClasesJava.Ambiente;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegistrarAmbiente extends Fragment {



    private EditText editTextNombre_Ambiente;
    private EditText editTextCodigo_Ambiente;
    private EditText editTextZona_Abiemte;

    private Button botton_Registrar_Ambiente;
    private DatabaseReference Ambientedb;


    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Ambientedb= FirebaseDatabase.getInstance().getReference("Ambientes");



        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.registrar_ambiente, container, false);
        //final TextView textView = root.findViewById(R.id.Registrar_Prestamo);
        editTextNombre_Ambiente=(EditText)root.findViewById(R.id.fragment_Nombre_Ambiente);
        editTextCodigo_Ambiente=(EditText)root.findViewById(R.id.fragment_Codigo_Ambiente);
        editTextZona_Abiemte=(EditText)root.findViewById(R.id.fragment_Zona_Ambiente);
        botton_Registrar_Ambiente=(Button) root.findViewById(R.id.fragment_boton_Registrar);

        botton_Registrar_Ambiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Nombre_Ambiente=editTextNombre_Ambiente.getText().toString();
                String Codigo_Ambiente=editTextCodigo_Ambiente.getText().toString();
                String Zona_Ambiente=editTextZona_Abiemte.getText().toString();

                if (!TextUtils.isEmpty(Nombre_Ambiente)){
                    String id= UUID.randomUUID().toString();
                    Ambiente ambiente =new Ambiente(id,Nombre_Ambiente,Codigo_Ambiente,Zona_Ambiente);
                    Ambientedb.child(id).setValue(ambiente);
                    Toast.makeText(getContext(),"Regisstro Exitoso",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(),"ingresar datos",Toast.LENGTH_SHORT).show();
                }

            }
        });
        return root;
    }
}