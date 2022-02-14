package com.example.ejercicio1_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText apellidos;
    private EditText edad;
    private EditText email;

    private Button enviar;
    private Button limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persona person = new Persona();

        nombre = findViewById(R.id.editTextTextPersonName);
        apellidos = findViewById(R.id.editTextTextPersonName2);
        edad = findViewById(R.id.editTextNumber);
        email = findViewById(R.id.editTextTextEmailAddress);

        enviar = findViewById(R.id.button5);
        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //String nom = "Sergio";
                //String apel = "Castillo";
                //int ed = 18;
                //String em = "sergioagustincastillo@gmail.com";
                person.setNombre(nombre.getText().toString());
                person.setApellidos(apellidos.getText().toString());
                String ed = edad.getText().toString();
                person.setEmail(email.getText().toString());
                int edad;
                if(ed.isEmpty()==true){
                    edad = 0;
                } else{
                    edad = Integer.parseInt(ed);
                }

                person.setEdad(edad);

                if (person.getNombre().isEmpty() || person.getApellidos().isEmpty() || ed.isEmpty() || person.getEmail().isEmpty()) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debes completar todos los campos", Toast.LENGTH_SHORT);
                    toast1.show();
                } else if (edad > 120) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Ingrese una edad válida!", Toast.LENGTH_SHORT);
                    toast1.show();
                } else if (person.getEmail().contains("@") == false || person.getEmail().contains(".") == false) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debe introducir un correo electrónico válido!", Toast.LENGTH_SHORT);
                    toast1.show();
                } else {
                    goResultados(person.getNombre(), person.getApellidos(), person.getEdad(), person.getEmail());
                }

            }
        });

        limpiar = findViewById(R.id.button6);
        limpiar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    public void goResultados(String nom, String apel, int edad, String em){
        Intent i = new Intent(this, Resultado.class);
        i.putExtra("nombre", nom);
        i.putExtra("apellidos", apel);
        i.putExtra("edad", edad);
        i.putExtra("email", em);
        startActivity(i);
    }

    public void limpiar(){
        nombre.setText("");
        apellidos.setText("");
        edad.setText("");
        email.setText("");
    }
}