package com.gavilan.septiembre_14.adapters;


import android.content.DialogInterface;
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

    @Override
    public void onBindViewHolder(@NonNull PaisAdapter.ViewHolder holder, int position) {
        holder.cargarInfo(listaPaises.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                LayoutInflater inflater = LayoutInflater.from(holder.itemView.getContext());
                View view1 = inflater.inflate(R.layout.dialogo,null);
                builder.setView(view1);
                EditText txt1 = view1.findViewById(R.id.editTextTextPersonName);
                Spinner sp = view1.findViewById(R.id.spinner);
                sp.setAdapter(new ArrayAdapter<String>(holder.itemView.getContext(), android.R.layout.simple_spinner_item,FormActivity.continentes));
                txt1.setText(listaPaises.get(position).getNombre());
                Toast.makeText(holder.itemView.getContext(), "largo:"+FormActivity.continentes.size(), Toast.LENGTH_SHORT).show();
                int index = FormActivity.continentes.indexOf(listaPaises.get(position).getContinente());
                sp.setSelection(index);
                builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FormActivity.paisesList.get(position).setNombre(txt1.getText().toString());
                        FormActivity.paisesList.get(position).setContinente(sp.getSelectedItem().toString());
                        notifyDataSetChanged();
                        Toast.makeText(holder.itemView.getContext(), "Modificado", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create();
                builder.show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                builder.setMessage("¿Deseas eliminar "+listaPaises.get(position).getNombre()+"?").
                        setTitle("Cuidado");
                builder.setCancelable(false);
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FormActivity.paisesList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.itemView.getContext(), "No pasa nada", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create();
                builder.show();
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
