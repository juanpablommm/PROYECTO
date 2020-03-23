package com.example.proyectoinventario.ui;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoinventario.R;

import java.util.List;

public abstract class adapterUsuarios extends RecyclerView.Adapter<adapterUsuarios.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre_Usuario;
        TextView apellido_Usuario;
        TextView cedula_Usuario;
        TextView telefono_Usuario;
        TextView correo_Usuario;
        TextView contrasena_Usuario;
        //TextView idUsuario;
        TextView rol_Usuario;


        public ViewHolder(View itemView) {
            super(itemView);
            nombre_Usuario=itemView.findViewById(R.id.textViewnombreConsultar);
            apellido_Usuario=itemView.findViewById(R.id.textViapellidoConsultar);
            telefono_Usuario=itemView.findViewById(R.id.textViatelefonoConsultar);
            cedula_Usuario=itemView.findViewById(R.id.textVicedulaConsultar);
            correo_Usuario=itemView.findViewById(R.id.textCorreoConsultar);
            contrasena_Usuario=itemView.findViewById(R.id.textVicontraseñaConsultar);
            rol_Usuario=itemView.findViewById(R.id.textVirolConsultar);

        }
    }

    public List<Usuarios> modeloslista;

    public adapterUsuarios(List<Usuarios> modeloslista) {
        this.modeloslista = modeloslista;
    }

    //public Adaptador(List<Modelo> modelos) {
    //  this.modeloslista = modelos;
    //}


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_consultar__cuentadantes, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre_Usuario.setText(modeloslista.get(position).getNombre_Usuario());
        holder.apellido_Usuario.setText(modeloslista.get(position).getApellido_Usuario());
        holder.telefono_Usuario.setText(modeloslista.get(position).getTelefono_Usuario());
        holder.cedula_Usuario.setText(modeloslista.get(position).getCedula_Usuario());
        holder.correo_Usuario.setText(modeloslista.get(position).getCorreo_Usuario());
        holder.contrasena_Usuario.setText(modeloslista.get(position).getContrasena_Usuario());
        holder.rol_Usuario.setText(modeloslista.get(position).getRol_Usuario());

    }

    @Override
    public int getItemCount() {
        return modeloslista.size();
    }
}


















/*public class adapterUsuarios extends RecyclerView.Adapter<Usuarios,adapterUsuarios.ViewHolder> {

    public adapterUsuarios() {
    }

    @NonNull
    @Override
    public Usuarios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_consultar__cuentadantes,parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Usuarios holder, int position) {
        holder.nombre_Usuario.setText(String.valueOf(nom))

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre_Usuario;
        TextView apellido_Usuario;
        TextView cedula_Usuario;
        TextView telefono_Usuario;
        TextView correo_Usuario;
        TextView contrasena_Usuario;
        //TextView idUsuario;
        TextView rol_Usuario;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre_Usuario=itemView.findViewById(R.id.textViewnombreConsultar);
            apellido_Usuario=itemView.findViewById(R.id.textViapellidoConsultar);
            telefono_Usuario=itemView.findViewById(R.id.textViatelefonoConsultar);
            cedula_Usuario=itemView.findViewById(R.id.textVicedulaConsultar);
            correo_Usuario=itemView.findViewById(R.id.textCorreoConsultar);
            contrasena_Usuario=itemView.findViewById(R.id.textVicontraseñaConsultar);
            rol_Usuario=itemView.findViewById(R.id.textVirolConsultar);


        }
    }
}
*/