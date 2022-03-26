package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    public TextView expresionIngresada;
    public TextView resultadoOperacion;

    public double primerOperando;
    public String operadorActual = "";
    public boolean esPermitidoOperador = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expresionIngresada = findViewById(R.id.expresionIngresada);
        resultadoOperacion = findViewById(R.id.resultadoOperacion);

        // Se asocia el manejador de eventos a cada uno de los botones numéricos.
        for (int i = 0; i < 10; i++) {
            int btn_ID = getResources().getIdentifier("btn_" + i, "id", getPackageName());
            findViewById(btn_ID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btn_Numerico_onClick(view);
                }
            });
        }

        findViewById(R.id.btn_Punto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esPermitidoOperador = false;
                AgregarAExpresion(".");
            }
        });

        findViewById(R.id.btn_Sumar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_Operador_onClick(view);
            }
        });

        findViewById(R.id.btn_Restar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_Operador_onClick(view);
            }
        });

        findViewById(R.id.btn_Multiplicar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_Operador_onClick(view);
            }
        });

        findViewById(R.id.btn_Dividir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_Operador_onClick(view);
            }
        });

        findViewById(R.id.btn_BorrarCaracter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expresionIngresada.setText(EliminarUltimoCaracter(expresionIngresada.getText().toString()));
                double resultadoExpresion = EvaluarExpresion(expresionIngresada.getText().toString());
                resultadoOperacion.setText(Double.toString(resultadoExpresion));

                if(expresionIngresada.getText().toString().length() > 0){
                    char ultimoCaracter = expresionIngresada.getText().toString().charAt(expresionIngresada.getText().toString().length() -1);
                    esPermitidoOperador = Character.isDigit(ultimoCaracter);
                }
            }
        });

        findViewById(R.id.btn_Limpiar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primerOperando = 0;
                expresionIngresada.setText("");
                resultadoOperacion.setText("");
                esPermitidoOperador = false;
            }
        });
    }

    public void btn_Numerico_onClick(View view) {
        int valor = new Integer(((MaterialButton) view).getText().toString());
        esPermitidoOperador = true;
        AgregarAExpresion(Integer.toString(valor));
        double resultadoExpresion = EvaluarExpresion(expresionIngresada.getText().toString());
        resultadoOperacion.setText(Double.toString(resultadoExpresion));
    }

    public void btn_Operador_onClick(View view){
        if(operadorActual.length() == 0 && expresionIngresada.getText().toString().length() > 0){
            primerOperando = new Double(expresionIngresada.getText().toString());
        }
        operadorActual = ((MaterialButton) view).getText().toString();
        if(esPermitidoOperador) {
            AgregarAExpresion(operadorActual);
        }

        esPermitidoOperador = false;
    }


}