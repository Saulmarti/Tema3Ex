package com.example.a2dam.tema3ex;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button guardar, mostrar;
    EditText dia,mes,dinero;
    TextView mostrardia,mostrarmes,mostrardinero;

    public static final String PREFS = "My preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            dia = (EditText) findViewById(R.id.diatxt);
            mes = (EditText) findViewById(R.id.mestxt);
            dinero = (EditText) findViewById(R.id.dinerotxt);
            mostrardia = (TextView) findViewById(R.id.mostrardia);
            mostrarmes = (TextView) findViewById(R.id.mostrarmes);
            mostrardinero = (TextView) findViewById(R.id.mostrardinero);


            mostrar = (Button) findViewById(R.id.mostrar);
            mostrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences preferencias = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
                    String dia = preferencias.getString("dia","");
                    String mes = preferencias.getString("mes","");
                    String dinero = preferencias.getString("dinero","");


                    mostrardia.setText("Dia: "+dia);
                    mostrarmes.setText("Mes: "+mes);
                    mostrardinero.setText("Dinero: "+dinero);



                }
            });

            guardar = (Button) findViewById(R.id.guardar);
            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences preferencias = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("dia", String.valueOf(dia.getText()));
                    editor.putString("mes", String.valueOf(mes.getText()));
                    editor.putString("dinero", String.valueOf(dinero.getText()));


                    editor.commit();


                }
            });

        }

    }

