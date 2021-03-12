package com.example.quiz1_eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SymptomOne extends AppCompatActivity {

    private CheckBox check1, check2, check3, check4, check5, check6, check7;
    private Button finalizar;
    private ConstraintLayout symptomScreen;
    private int nexoValor, sintomaValor, valorTotal;
    private String nombreUsuario, idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_one);

        check1 = findViewById(R.id.checkSymptom1);
        check2 = findViewById(R.id.checkSymptom2);
        check3 = findViewById(R.id.checkSymptom3);
        check4 = findViewById(R.id.checkSymptom4);
        check5 = findViewById(R.id.checkSymptom5);
        check6 = findViewById(R.id.checkSymptom6);
        check7 = findViewById(R.id.checkSymptom7);
        finalizar = findViewById(R.id.finalizar);
        symptomScreen = findViewById(R.id.symptomScreen);

        sintomaValor = 0;
        valorTotal = 0;

        nombreUsuario = getIntent().getExtras().getString("nombre2");
        idUsuario = getIntent().getExtras().getString("id2");
        nexoValor = getIntent().getExtras().getInt("valores");

        checkboxVerificacion();
        finalizar();
    }

    public void finalizar() {

        finalizar.setOnClickListener(

                v -> {

                    checkboxValor();
                    valorTotal = sintomaValor + nexoValor;
                    Intent i = new Intent(this, MainActivity.class);
                    guardarInfo();
                    startActivity(i);
                    finish();

                }

        );
    }

    public void checkboxValor() {

        if (check1.isChecked()) {

            sintomaValor = sintomaValor + 4;
        }

        if (check2.isChecked()) {

            sintomaValor = sintomaValor + 4;
        }

        if (check3.isChecked()) {

            sintomaValor = sintomaValor + 4;
        }

        if (check4.isChecked()) {

            sintomaValor = sintomaValor + 4;
        }

        if (check5.isChecked()) {

            sintomaValor = sintomaValor + 4;
        }

        if (check6.isChecked()) {

            sintomaValor = sintomaValor + 4;
        }

    }

    public void guardarInfo() {

        SharedPreferences preferences = getSharedPreferences("datos", MODE_PRIVATE);
        String infoUsuario = nombreUsuario + "," + idUsuario + "," + valorTotal + "\n";
        String infoActual = preferences.getString("usuario", "");
        preferences.edit().putString("usuario", infoActual + infoUsuario).apply();
    }

    public void checkboxVerificacion(){

        finalizar.setEnabled(false);

        new Thread(

                ()->{

                    while(true){

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if(check1.isChecked() || check2.isChecked() || check3.isChecked() || check4.isChecked() || check5.isChecked()
                                || check6.isChecked() || check7.isChecked()){

                            runOnUiThread(
                                    ()->{
                                        finalizar.setEnabled(true);
                                    }
                            );

                        }else{

                            runOnUiThread(

                                    ()->{
                                        finalizar.setEnabled(false);
                                    }

                            );
                        }

                    }

                }

        ).start();

    }
}