package com.example.proyectoinventario.ui.ConsultarCuentadantes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectoinventario.AdapterUsuarios;
import com.example.proyectoinventario.Muestras;
import com.example.proyectoinventario.R;

import com.example.proyectoinventario.ui.ClasesJava.Usuarios;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link ConsultarCuentadantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarCuentadantes extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View vista;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Usuarios> list;
    AdapterUsuarios adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsultarCuentadantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Consultar_Cuentadantes.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultarCuentadantes newInstance(String param1, String param2) {
        ConsultarCuentadantes fragment = new ConsultarCuentadantes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_consultar__cuentadantes, container, false);

        recyclerView = (RecyclerView) vista.findViewById(R.id.RecyclerUsuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<Usuarios>();


        reference = FirebaseDatabase.getInstance().getReference().child("Usuarios");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Usuarios p = dataSnapshot1.getValue(Usuarios.class);
                    list.add(p);

                }


                adapter=new AdapterUsuarios(vista,container.getContext());
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Opass...", Toast.LENGTH_SHORT).show();
            }
        });




        return vista;
    }



}
