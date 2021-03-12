package com.example.quiz1_eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class NexoOne extends AppCompatActivity {

    private CheckBox check1, check2, check3, check4, check5;
    private Button continuar;
    private ConstraintLayout nexoScreen;
    private String nombreUsuario, idUsuario;
    private int nexoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo_one);

        check1 = findViewById(R.id.checkNexo1);
        check2 = findViewById(R.id.checkNexo2);
        check3 = findViewById(R.id.checkNexo3);
        check4 = findViewById(R.id.checkNexo4);
        check5 = findViewById(R.id.checkNexo5);
        continuar = findViewById(R.id.continuar2);
        nexoScreen = findViewById(R.id.nexoScreen);

        nexoValor=0;

        nombreUsuario = getIntent().getExtras().getString("nombre");
        idUsuario = getIntent().getExtras().getString("id");

        continuar();
    }

    public void continuar(){

        continuar.setOnClickListener(

                v->{

                    if(check1.isChecked() || check2.isChecked() || check3.isChecked() || check4.isChecked() || check5.isChecked()){

                        checkboxValor();
                        Toast.makeText(this, "nexoValor= " +  nexoValor, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(this, SymptomOne.class);
                        i.putExtra("nombre2",nombreUsuario);
                        i.putExtra("id2",idUsuario);
                        i.putExtra("valores",nexoValor);
                        startActivity(i);
                        finish();
                    }else{
                            Toast.makeText(this, "Escoja al menos una opción", Toast.LENGTH_SHORT).show();
                    }

                }

        );

    }

    public void checkboxValor(){

        if (check1.isChecked()){

            nexoValor=nexoValor+3;
        }

        if (check2.isChecked()){

            nexoValor=nexoValor+3;
        }

        if (check3.isChecked()){

            nexoValor=nexoValor+3;
        }

        if (check4.isChecked()){

            nexoValor=nexoValor+3;
        }

    }
}