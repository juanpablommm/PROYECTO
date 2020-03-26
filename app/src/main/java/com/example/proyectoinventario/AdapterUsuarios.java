package com.example.proyectoinventario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoinventario.ui.ConsultarCuentadantes.ConsultarCuentadantes;

import java.util.ArrayList;

public class AdapterUsuarios extends RecyclerView.Adapter<AdapterUsuarios.MyViewHolder> {


    Context context;
    ArrayList<Usuarios> usuariosArrayList;


    public AdapterUsuarios(Context c , ArrayList<Usuarios> p){

        context= c;
        usuariosArrayList= p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mostrar,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomnbre.setText(usuariosArrayList.get(position).getNombre_Usuario());
        holder.apellidos.setText(usuariosArrayList.get(position).getApellido_Usuario());
        holder.telefono.setText(usuariosArrayList.get(position).getTelefono_Usuario());
        holder.cedula.setText(usuariosArrayList.get(position).getCedula_Usuario());
        holder.correo.setText(usuariosArrayList.get(position).getCorreo_Usuario());
        holder.contraseña.setText(usuariosArrayList.get(position).getContrasena_Usuario());
        holder.rol.setText(usuariosArrayList.get(position).getRol_Usuario());


    }

    @Override
    public int getItemCount() {
        return usuariosArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nomnbre, apellidos, telefono, cedula, correo, contraseña, rol;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomnbre=(TextView) itemView.findViewById(R.id.textViewnombreConsultar);
            apellidos=(TextView) itemView.findViewById(R.id.textViapellidoConsultar);
            telefono=(TextView) itemView.findViewById(R.id.textViatelefonoConsultar);
            cedula=(TextView) itemView.findViewById(R.id.textVicedulaConsultar);
            correo=(TextView) itemView.findViewById(R.id.textCorreoConsultar);
            contraseña=(TextView) itemView.findViewById(R.id.textVicontraseñaConsultar);
            rol=(TextView) itemView.findViewById(R.id.textVirolConsultar);

        }
    }
}
