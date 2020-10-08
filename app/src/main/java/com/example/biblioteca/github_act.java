package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.libros;

public class github_act extends AppCompatActivity {

    private Spinner spin;
    private TextView textv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spin = (Spinner) findViewById(R.id.spin);
        textv = (TextView) findViewById(R.id.txtv);

        ArrayList<String> listalibros=(ArrayList<String>)getIntent().getSerializableExtra("listalibros");
        ArrayAdapter adapt =new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listalibros);

        spin.setAdapter(adapt);
    }

    public void mostrar (View v)
    {
        libros lib = new libros();

        String libro = spin.getSelectedItem().toString();

        int  Farenheit = Integer.parseInt(lib.getFarenheit());
        int  Revival = Integer.parseInt(lib.getRevival());
        int  ElAlquimista = Integer.parseInt(lib.getElAlquimista());
        int  ElPoder = Integer.parseInt(lib.getElPoder());
        int  Despertar = Integer.parseInt(lib.getDespertar());

        if(libro.equals("Farenheit"))
        {
            textv.setText("Su precio es: "+Farenheit);
        }
        else if(libro.equals("Revival"))
        {
            textv.setText("Su precio es: "+Revival);
        }
        else if(libro.equals("El Alquimista"))
        {
            textv.setText("Su precio es: "+ElAlquimista);
        }
        else if(libro.equals("El Poder"))
        {
            textv.setText("Su precio es: "+ElPoder);
        }
        else if(libro.equals("Despertar"))
        {
            textv.setText("Su precio es: "+Despertar);
        }
    }
}