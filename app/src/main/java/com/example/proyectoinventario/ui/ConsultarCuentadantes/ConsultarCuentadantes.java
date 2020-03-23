package com.example.proyectoinventario.ui.ConsultarCuentadantes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoinventario.R;
import com.example.proyectoinventario.ui.ClasesJava.Usuarios;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    TextView textViewnombre;
    TextView textViewapellido;
    TextView textViewtelefono;
    TextView textViewcedula;
    TextView textViewcorreo;
    TextView textViewcontraseña;
    TextView textViewrol;
    Button buttonleer;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_consultar__cuentadantes, container, false);
        textViewnombre=vista.findViewById(R.id.textViewnombreConsultar);
        textViewapellido=vista.findViewById(R.id.textViapellidoConsultar);
        textViewtelefono=vista.findViewById(R.id.textViatelefonoConsultar);
        textViewcedula=vista.findViewById(R.id.textVicedulaConsultar);
        textViewcorreo=vista.findViewById(R.id.textCorreoConsultar);
        textViewcontraseña=vista.findViewById(R.id.textVicontraseñaConsultar);
        textViewrol=vista.findViewById(R.id.textVirolConsultar);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference= database.getReference();
        databaseReference.child("Usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (final DataSnapshot snapshot : dataSnapshot.getChildren()){
                    databaseReference.child("Usuarios").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            Usuarios usuarios=snapshot.getValue(Usuarios.class);
                            String nombre=usuarios.getNombre_Usuario();
                            String apellido=usuarios.getApellido_Usuario();
                            String telefono=usuarios.getTelefono_Usuario();
                            String cedula=usuarios.getCedula_Usuario();
                            String correo=usuarios.getCorreo_Usuario();
                            String contraseña=usuarios.getContrasena_Usuario();
                            String rol=usuarios.getRol_Usuario();
                            textViewapellido.setText("Apellidos: "+apellido);
                            textViewnombre.setText("Nombre: "+ nombre);
                            textViewtelefono.setText("Telefono: "+telefono);
                            textViewcedula.setText("Cedula: "+cedula);
                            textViewcorreo.setText("Correo: "+correo);
                            textViewcontraseña.setText("Contraseña: "+contraseña);
                            textViewrol.setText("Rol: " +rol);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        return vista;
    }



}
