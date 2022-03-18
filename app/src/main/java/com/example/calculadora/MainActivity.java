package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSuma;
    private Button btnResta;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnLimp;

    private TextView resultado;

    private EditText numeroA;
    private EditText numeroB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        numeroA = findViewById(R.id.numeroA);
        numeroB = findViewById(R.id.numeroB);

        btnLimp = findViewById(R.id.btnLimp);
        btnLimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("0");
                numeroA.setText("");
                numeroB.setText("");
            }
        });

        btnSuma = findViewById(R.id.btnSuma);
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(suma(Integer.parseInt(numeroA.getText().toString()), Integer.parseInt(numeroB.getText().toString()))+"");
            }
        });

        btnResta = findViewById(R.id.btnResta);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);

    }

    public int suma(int a, int b){
        return a+b;
    }

}