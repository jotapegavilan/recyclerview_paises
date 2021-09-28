package com.gavilan.septiembre_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.gavilan.septiembre_14.models.Pais;

public class EditActivity extends AppCompatActivity {

    private EditText txtNombreEdit;
    private Button btnCancelar, btnActualizar;
    private ImageView imgContinenteEdit;
    private Spinner spContinentesEdit;


    public void cargarSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                FormActivity.continentes
        );
        spContinentesEdit.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        // REFERENCIAS DESDE JAVA A XML
        txtNombreEdit = findViewById(R.id.txtNombreEdit);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnCancelar = findViewById(R.id.btnCancelar);
        imgContinenteEdit = findViewById(R.id.imgContienenteEdit);
        spContinentesEdit = findViewById(R.id.spContinentesEdit);
        cargarSpinner();

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        Pais paisObtenido = (Pais) bundle.get("objetoPais");

        // Mostrar en pantalla los datos del país obtenido

        txtNombreEdit.setText(paisObtenido.getNombre());

        switch ( paisObtenido.getContinente() ){
            case "América":
                imgContinenteEdit.setImageResource(R.drawable.america);
                spContinentesEdit.setSelection(4);
                break;
            case "Europa":
                imgContinenteEdit.setImageResource(R.drawable.europa);
                spContinentesEdit.setSelection(1);
                break;
            case "Asia":
                imgContinenteEdit.setImageResource(R.drawable.asia);
                spContinentesEdit.setSelection(3);
                break;
            case "África":
                imgContinenteEdit.setImageResource(R.drawable.africa);
                spContinentesEdit.setSelection(2);
                break;
            case "Oceanía":
                imgContinenteEdit.setImageResource(R.drawable.australia);
                spContinentesEdit.setSelection(5);
                break;

        }

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(EditActivity.this, ListadoActivity.class) );
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombreEdit.getText().toString();
                String continente = spContinentesEdit.getSelectedItem().toString();
                actualizarPais(paisObtenido, nombre, continente);
            }
        });


    }

    public void actualizarPais(Pais pActual, String nombre, String continente){
        for( Pais p : FormActivity.paisesList ){
            if(p.equals(pActual)){ // país encontrado
                p.setNombre(nombre);
                p.setContinente(continente);
                startActivity( new Intent(EditActivity.this, ListadoActivity.class) );
                break;
            }
        }
    }
}