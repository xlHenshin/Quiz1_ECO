package com.example.quiz1_eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

        checkboxVerificacion();
        continuar();
    }

    public void continuar(){

        continuar.setOnClickListener(

                v->{

                    checkboxValor();
                    Intent i = new Intent(this, SymptomOne.class);
                    i.putExtra("nombre2",nombreUsuario);
                    i.putExtra("id2",idUsuario);
                    i.putExtra("valores",nexoValor);
                    startActivity(i);
                    finish();

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

    public void checkboxVerificacion(){

        continuar.setEnabled(false);
        continuar.setBackgroundResource(R.drawable.editbuttonbackground2);
        new Thread(

                ()->{

                    while(true){

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if(check1.isChecked() || check2.isChecked() || check3.isChecked() || check4.isChecked() || check5.isChecked()){

                            runOnUiThread(
                                    ()->{
                                        continuar.setEnabled(true);
                                        continuar.setBackgroundResource(R.drawable.editbuttonbackground);
                                    }
                            );

                        }else{

                            runOnUiThread(

                                    ()->{
                                        continuar.setEnabled(false);
                                        continuar.setBackgroundResource(R.drawable.editbuttonbackground2);
                                    }

                            );
                        }

                    }

                }

        ).start();

    }
}