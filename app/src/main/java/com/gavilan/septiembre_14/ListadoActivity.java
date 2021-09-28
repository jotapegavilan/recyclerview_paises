package com.gavilan.septiembre_14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.gavilan.septiembre_14.adapters.PaisAdapter;
import com.gavilan.septiembre_14.models.Pais;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {


    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        recycler = findViewById(R.id.recycler);
        cargarRecycler();




    }

    public void cargarRecycler(){
        recycler.setLayoutManager(new LinearLayoutManager(this));
        PaisAdapter adapter = new PaisAdapter(FormActivity.paisesList);
        recycler.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mi_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // condicional - switch

        switch (item.getItemId()){ // tomamos el id del item seleccionado
            case R.id.menu_inicio:
                Toast.makeText(this, "Inicio", Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_formulario:
                //Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                //Intent intent = new Intent(getBaseContext(), FormActivity.class);
                //Intent intent = new Intent(MainActivity.this, FormActivity.class);
                Intent intent = new Intent(this, FormActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_listado:
                Intent intent1 = new Intent(this,ListadoActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }


}