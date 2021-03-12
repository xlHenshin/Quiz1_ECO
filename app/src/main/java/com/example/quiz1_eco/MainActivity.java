package com.example.quiz1_eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView listaEncuestados;
    private Button registrarPersona;
    private ConstraintLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaEncuestados = findViewById(R.id.listaencuestas);
        registrarPersona = findViewById(R.id.registrar);
        main = findViewById(R.id.mainScreen);

        registrarPersona.setOnClickListener(

                v->{

                    Intent i = new Intent(this,Register.class);
                    startActivity(i);

                }

        );

    }

    public void cargarInfo(){

        String infoUsuario = getSharedPreferences("datos", MODE_PRIVATE).getString("usuario", "No hay datos almacenados");
        listaEncuestados.setText(infoUsuario);

    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarInfo();
    }
}