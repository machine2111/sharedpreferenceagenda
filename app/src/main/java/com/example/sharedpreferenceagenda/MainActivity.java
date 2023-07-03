package com.example.sharedpreferenceagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
    }

    //Metodo para el boton guardar

    public void guardar(View view){
        String nombre = et1.getText().toString();
        String datos = et2.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre,datos);
        obj_editor.commit();

        Toast.makeText(this,"El contacto ha sido guardado", Toast.LENGTH_SHORT).show();
    }

    //Metodo para el boton buscar

    public void buscar(View view) {
        String nombre = et1.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre, "");

        if (datos.length() == 0) {
            Toast.makeText(this, "No se encontro registro", Toast.LENGTH_SHORT).show();
            et2.setText(" ");
        } else {jhosp
            et2.setText(datos);
        }
    }
}