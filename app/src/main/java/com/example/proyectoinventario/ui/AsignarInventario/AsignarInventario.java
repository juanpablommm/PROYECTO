package com.example.proyectoinventario.ui.AsignarInventario;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectoinventario.R;
import com.example.proyectoinventario.ui.ClasesJava.Inventario;
import com.example.proyectoinventario.ui.ClasesJava.Prestamo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class AsignarInventario extends Fragment {

    private EditText editTextInstructor;
    private EditText editTextApe;
    private EditText editTextMateriales;
    private EditText editTextCantidadMaterial;
    private EditText editTextEquipos;
    private EditText editTextCantidadEquipos;
    private  EditText editTextHerramimientas;
    private EditText editTextCantidadHerramientas;
    //private Spinner Spinner_Prestamo;
    private Button botton_Asignar;

    private DatabaseReference Inventariodb;

    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Inventariodb = FirebaseDatabase.getInstance().getReference("Inventario");

        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.asignar_inventario, container, false);
        editTextInstructor = (EditText) root.findViewById(R.id.Instructor);
        editTextApe = (EditText) root.findViewById(R.id.Ape);
        editTextMateriales = (EditText) root.findViewById(R.id.material);
        editTextCantidadMaterial = (EditText) root.findViewById(R.id.cantiMa);
        editTextEquipos = (EditText) root.findViewById(R.id.Equip);
        editTextCantidadEquipos = (EditText) root.findViewById(R.id.CantEq);
        editTextHerramimientas = (EditText) root.findViewById(R.id.Herrami);
        editTextCantidadHerramientas = (EditText) root.findViewById(R.id.CanHerram);


        botton_Asignar=(Button) root.findViewById(R.id.BottnAs);

        botton_Asignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Instructor =editTextInstructor.getText().toString();
                String Ape=editTextApe.getText().toString();
                String Materiales=editTextMateriales.getText().toString();
                String CantidadMaterial=editTextCantidadMaterial.getText().toString();
                String Equipos=editTextEquipos.getText().toString();
                String CantidadEquipos=editTextCantidadEquipos.getText().toString();
                String Herramimientas=editTextHerramimientas.getText().toString();
                String CantidadHerramientas=editTextCantidadHerramientas.getText().toString();
                //Spinner SpinnerPrestamo=Spinner_Prestamo.getT//


                if (!TextUtils.isEmpty(Instructor)){
                    String id= UUID.randomUUID().toString();
                    Inventario inventario =new Inventario(id,Instructor,Ape,Materiales,CantidadMaterial,Equipos,
                            CantidadEquipos,Herramimientas,CantidadHerramientas);
                    Inventariodb.child(id).setValue(inventario);
                    Toast.makeText(getContext(),"Regisstro Exitoso",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(),"ingresar datos",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //final TextView textView = root.findViewById(R.id.tituloIn);
        toolsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;

    }
}