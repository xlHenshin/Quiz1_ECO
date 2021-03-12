package com.example.quiz1_eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText nombre, identificacion;
    private Button continuar;
    private boolean permitirContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = findViewById(R.id.name);
        identificacion = findViewById(R.id.id);
        continuar = findViewById(R.id.continuar1);

        continuar.setOnClickListener(

                v->{

                    verificarInfo();
                    String nombreUsuario = nombre.getText().toString();
                    String idUsuario = identificacion.getText().toString();

                    if(nombreUsuario==null || idUsuario==null || nombreUsuario.isEmpty() || idUsuario.isEmpty()){

                        Toast.makeText(this, "Digite todos los datos", Toast.LENGTH_SHORT).show();
                    }else if(permitirContinuar){

                        Intent i = new Intent(this, NexoOne.class);
                        i.putExtra("nombre", nombreUsuario);
                        i.putExtra("id", idUsuario);
                        startActivity(i);
                        nombre.setText("");
                        finish();
                    }

                }

        );
    }

    public void verificarInfo(){

        permitirContinuar=true;

        String infoUsuario = getSharedPreferences("datos", MODE_PRIVATE).getString("usuario", "No hay datos almacenados");

        if (infoUsuario.contains(nombre.getText().toString()) && infoUsuario.contains(identificacion.getText().toString())){

            Toast.makeText(this, "El usuario ya ha hecho la encuesta", Toast.LENGTH_SHORT).show();
            permitirContinuar=false;
        }

    }
}