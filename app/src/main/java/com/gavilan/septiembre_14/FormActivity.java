package com.gavilan.septiembre_14;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gavilan.septiembre_14.models.Pais;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FormActivity extends AppCompatActivity {
    /*
    <item>Selecciona un continente</item>
        <item>Europa</item>
        <item>África</item>
        <item>Asia</item>
        <item>América</item>
        <item>Oceanía</item>
     */
    public static ArrayList<Pais> paisesList = new ArrayList<>();
    public static ArrayList<String> continentes = new ArrayList<String>();

    EditText txtNombre;
    Button btnGuardar;
    Spinner spContinentes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtNombre = findViewById(R.id.txtNombre);
        btnGuardar = findViewById(R.id.btn_guardar_pais);
        spContinentes = findViewById(R.id.spContinentes);

        // eventos click al btn
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pais pais = new Pais( txtNombre.getText().toString(),
                        spContinentes.getSelectedItem().toString());
                paisesList.add(pais);
            }
        });

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
