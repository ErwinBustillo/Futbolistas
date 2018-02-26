package com.edu.uninorte.futbolistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public String candi;
    EditText campoNombre;
    EditText campoApellido;
    EditText campoPosicion;
    EditText campoEdad;
    Jugador jug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        campoNombre =(EditText) findViewById(R.id.campoNombre);
        campoApellido =(EditText) findViewById(R.id.campoApellido);
        campoPosicion =(EditText) findViewById(R.id.campoPosicion);
        campoEdad =(EditText) findViewById(R.id.campoEdad);

        jug = (Jugador) getIntent().getSerializableExtra("jugador");

        campoNombre.setText(jug.nombre);
        campoApellido.setText(jug.apellido);
        campoPosicion.setText(jug.posicion);
        campoEdad.setText(jug.edad+"");

    }

    public void onClickSave(View view) {
       // candi=""
        if (campoNombre.equals("")){
            return;
        }
        if (campoApellido.equals("")){
            return;
        }
        if (campoPosicion.equals("")){
            return;
        }
        if (campoEdad.equals("")){
            return;
        }

        if (candi.equals("")){
            candi="On/Off";
        }


        Jugador jugador = new Jugador(jug.id,campoNombre.getText().toString(),campoApellido.getText().toString(),campoPosicion.getText().toString(),candi,Integer.parseInt(campoEdad.getText().toString()) );

        Intent response = new Intent();
        response.putExtra("jugador",jugador);
        setResult(Activity.RESULT_OK,response);
        finish();

    }

    public void onClickOff(View view) {
        candi="OFF";
    }

    public void onClickOn(View view) {
        candi="ON";
    }
}
