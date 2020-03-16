package com.example.proyectoinventario.ui.RegistrarActivos;

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
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectoinventario.ui.ClasesJava.Activos;
import com.example.proyectoinventario.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegistrarActivos extends Fragment {

    EditText Nombre_activo;
    EditText Cantidad_activo;
    EditText Marca_activo;
    EditText Serial_activo;


    private ShareViewModel shareViewModel;

    private Spinner Spinner_Activo;
    Button buttonRegistrar;
    private DatabaseReference Activosdb;

    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {
        Activosdb= FirebaseDatabase.getInstance().getReference("Activos");

        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.registrar_activos, container, false);

        Nombre_activo=(EditText)root.findViewById(R.id.In_Nombre_Activo);
        Cantidad_activo=(EditText)root.findViewById(R.id.In_Cantidad_Activo);
        Marca_activo=(EditText)root.findViewById(R.id.In_Marca_Activo);
        Serial_activo=(EditText)root.findViewById(R.id.In_Serial_Activo);
        Spinner_Activo=(Spinner) root.findViewById(R.id.Spinner_Activo);
        buttonRegistrar=(Button) root.findViewById(R.id.button_Registrar_Activo);

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NombreActivo=Nombre_activo.getText().toString();
                String CantidadActivo=Cantidad_activo.getText().toString();
                String MarcaActivo=Marca_activo.getText().toString();
                String SerialActivo=Serial_activo.getText().toString();

                if (!TextUtils.isEmpty(NombreActivo)){
                    String id= UUID.randomUUID().toString();
                    Activos activos=new Activos(id,NombreActivo, CantidadActivo, MarcaActivo, SerialActivo);
                    Activosdb.child(id).setValue(activos);
                    Toast.makeText(getContext(),"Regisstro Exitoso",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(),"ingresar datos",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //final TextView textView = root.findViewById(R.id.RegistrarActivos);

        return root;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner_Activo = view.findViewById(R.id.Spinner_Activo);


        String [] inventario= {"Equipo","Material","Herramienta"};
        ArrayAdapter<String> adapter_inventario= new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, inventario);
        Spinner_Activo.setAdapter(adapter_inventario);

    }
}

