package com.example.proyectoinventario.ui.RegistrarPrestamo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectoinventario.R;
import com.example.proyectoinventario.ui.Ambiente;
import com.example.proyectoinventario.ui.Prestamo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegistrarPrestamo extends Fragment {

    private EditText editTextNombre_Prestamo;
    private EditText editTextSerial_Ambiente;
    private EditText editTextMarca_Prestamo;
    private EditText editTextCantidad_Prestamo;
    private EditText editTextSpinner_Prestamo;
    private Spinner Spinner_Prestamo;
    private Button botton_Registrar_Prestamo;

    private DatabaseReference Prestamodb;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Prestamodb = FirebaseDatabase.getInstance().getReference("Prestamo");


        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.registrar_prestamo, container, false);
        final TextView textView = root.findViewById(R.id.Registrar_Ambiente);
        editTextNombre_Prestamo = (EditText) root.findViewById(R.id.fragment_Nombre_Ambiente);
        editTextSerial_Ambiente = (EditText) root.findViewById(R.id.fragment_Codigo_Ambiente);
        editTextMarca_Prestamo = (EditText) root.findViewById(R.id.fragment_Zona_Ambiente);
        editTextCantidad_Prestamo = (EditText) root.findViewById(R.id.fragment_Serial_Prestamo);
        Spinner_Prestamo = (Spinner) root.findViewById(R.id.Spinner_fragment_prestamo);

        botton_Registrar_Prestamo=(Button) root.findViewById(R.id.fragment_boton_eliminar);

        botton_Registrar_Prestamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Nombre_Prestamo=editTextNombre_Prestamo.getText().toString();
                String Serial_Prestamo=editTextSerial_Ambiente.getText().toString();
                String Marca_Prestamo=editTextMarca_Prestamo.getText().toString();
                String Cantidad_Prestamo=editTextCantidad_Prestamo.getText().toString();
                //Spinner SpinnerPrestamo=Spinner_Prestamo.getT//


                if (!TextUtils.isEmpty(Nombre_Prestamo)){
                    String id= UUID.randomUUID().toString();
                    Prestamo prestamo =new Prestamo(id,Nombre_Prestamo,Serial_Prestamo,Marca_Prestamo,Cantidad_Prestamo);
                    Prestamodb.child(id).setValue(prestamo);
                    Toast.makeText(getContext(),"Regisstro Exitoso",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(),"ingresar datos",Toast.LENGTH_SHORT).show();
                }
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;



    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner_Prestamo = view.findViewById(R.id.Spinner_fragment_prestamo);


        String [] inventario= {"Equipo","Material","Herramienta"};
        ArrayAdapter<String> adapter_Prestamo= new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, inventario);
        Spinner_Prestamo.setAdapter(adapter_Prestamo);


    }


}