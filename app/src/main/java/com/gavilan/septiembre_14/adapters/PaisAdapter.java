package com.gavilan.septiembre_14.adapters;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.gavilan.septiembre_14.EditActivity;
import com.gavilan.septiembre_14.FormActivity;
import com.gavilan.septiembre_14.R;
import com.gavilan.septiembre_14.models.Pais;

import java.util.ArrayList;

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.ViewHolder> {
    ArrayList<Pais> listaPaises;
    public PaisAdapter(ArrayList<Pais> lista){
        this.listaPaises = lista;
    }

    @NonNull
    @Override
    public PaisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_pais,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void print(String mensaje, Context context){
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
    }

    public void crearAlerta(Pais p, Context context){
        AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        alerta.setTitle("CUIDADO");
        alerta.setMessage("¿Seguro de borrar a "+p.getNombre()+" ?");
        alerta.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FormActivity.paisesList.remove(p);
                listaPaises = FormActivity.paisesList;

                notifyDataSetChanged();

            }
        });
        alerta.setNegativeButton("Cancelar",null);
        alerta.create();
        alerta.show();

    }

    @Override
    public void onBindViewHolder(@NonNull PaisAdapter.ViewHolder holder, int position) {
        holder.cargarInfo(listaPaises.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pais paisSelected = listaPaises.get(position);
                Intent intent =
                        new Intent( holder.itemView.getContext() , EditActivity.class);
                intent.putExtra("objetoPais", paisSelected);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Pais paisSelected = listaPaises.get(position);
                crearAlerta(paisSelected, holder.itemView.getContext());
                return false;
            }
        });




    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContinente;
        TextView txtNombrePais, txtNombreContinente;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContinente = itemView.findViewById(R.id.imgContinente);
            txtNombrePais = itemView.findViewById(R.id.txtNombrePais);
            txtNombreContinente = itemView.findViewById(R.id.txtNombreContinente);
        }

        public void cargarInfo(Pais p) {
            txtNombrePais.setText(p.getNombre());
            txtNombreContinente.setText(p.getContinente());
            // selecctor de imagen
            if (p.getContinente().equals("Europa")) {
                imgContinente.setImageResource(R.drawable.europa);
            }
            if (p.getContinente().equals("África")) {
                imgContinente.setImageResource(R.drawable.africa);
            }
            if (p.getContinente().equals("Asia")) {
                imgContinente.setImageResource(R.drawable.asia);
            }
            if (p.getContinente().equals("América")) {
                imgContinente.setImageResource(R.drawable.america);
            }
            if (p.getContinente().equals("Oceanía")) {
                imgContinente.setImageResource(R.drawable.australia);
            }

        }

    }
}
