package com.gavilan.septiembre_14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.gavilan.septiembre_14.models.Pais;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FormActivity.paisesList.add(new Pais("Chile","América"));
        FormActivity.paisesList.add(new Pais("Argentina","América"));
        FormActivity.paisesList.add(new Pais("Brasil","América"));
        FormActivity.continentes.add("Europa");
        FormActivity.continentes.add("África");
        FormActivity.continentes.add("Asia");
        FormActivity.continentes.add("América");
        FormActivity.continentes.add("Oceanía");


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