package com.edu.uninorte.futbolistas;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lista;
    CustomAdapter customAdapter;
    ArrayList<Jugador> jugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=(ListView) findViewById(R.id.lista);
        jugadores = new ArrayList<Jugador>();
        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,datos);

// Create the adapter to convert the array to views
        customAdapter= new CustomAdapter(this, jugadores);

        Jugador jugador = new Jugador(0, "Falcao","Garcia","9","on/off",10);
        Jugador jugador2 = new Jugador(1, "Jackson","Martinez","14","on/off",11);
        Jugador jugador3 = new Jugador(2, "James ","Rodriguez","10","on/off",12);
        Jugador jugador4 = new Jugador(3, "David","Ospina","1","on/off",13);
        Jugador jugador5 = new Jugador(4, "Jeison","Murillo","2","on/off",14);
        Jugador jugador6 = new Jugador(5, "Fabra","X","4","on/off",15);
        Jugador jugador7 = new Jugador(6, "Oscar","Murillo","12","on/off",16);

        customAdapter.add(jugador);
        customAdapter.add(jugador2);
        customAdapter.add(jugador3);
        customAdapter.add(jugador4);
        customAdapter.add(jugador5);
        customAdapter.add(jugador6);
        customAdapter.add(jugador7);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),"Me accione",Toast.LENGTH_SHORT);
            }
        });
        lista.setAdapter(customAdapter);



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            if ( resultCode == RESULT_OK){
                Jugador  jug =(Jugador) data.getSerializableExtra("jugador");
                jugadores.remove(jug.id);
                jugadores.add(jug);
                customAdapter.notifyDataSetChanged();
                /*String operacion=(String) data.getStringExtra("operaciones");
                op=operacion;
                Toast toast = Toast.makeText(this, operacion, Toast.LENGTH_SHORT);
                toast.show();
                //operation.setText(" ");
                operation.setText(op);
                resultado.setText(" ");
                resultado.setText(eval(op)+"");
                op="";
                operation.setText(" ");*/
            }
        }
    }



    public void onClickEditar(View view) {
        Toast.makeText(view.getContext(),"Me accione",Toast.LENGTH_SHORT);
        Intent i = new Intent(view.getContext(),SecondActivity.class);
        i.putExtra("jugador",jugadores.get((int)view.getTag()));
        startActivityForResult(i,1);
    }
}
