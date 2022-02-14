package com.example.ejercicio1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    private TextView Tnombre;
    private TextView Tapellidos;
    private TextView Tedad;
    private TextView Temail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        String nombre = getIntent().getExtras().getString("nombre");
        String apellidos = getIntent().getExtras().getString("apellidos");
        int edad = getIntent().getExtras().getInt("edad");
        String email = getIntent().getExtras().getString("email");

        Tnombre = findViewById(R.id.textView9);
        Tapellidos = findViewById(R.id.textView10);
        Tedad = findViewById(R.id.textView11);
        Temail = findViewById(R.id.textView12);

        Tnombre.setText(nombre);
        Tapellidos.setText(apellidos);
        Tedad.setText(""+edad);
        Temail.setText(email);
    }
}