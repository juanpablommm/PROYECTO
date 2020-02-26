package com.example.proyectoinventario.ui.RegistrarActivos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectoinventario.R;

public class RegistrarActivos extends Fragment {

    private ShareViewModel shareViewModel;

    private Spinner Spinner_Activo;

    public View onCreateView(@NonNull LayoutInflater inflater,


                             ViewGroup container, Bundle savedInstanceState) {


        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.registrar_activos, container, false);
        Spinner_Activo=(Spinner) root.findViewById(R.id.Spinner_Activo);
        final TextView textView = root.findViewById(R.id.RegistrarActivos);

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

