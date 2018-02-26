package com.edu.uninorte.futbolistas;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Visitante on 26/02/2018.
 */

public class CustomAdapter extends ArrayAdapter<Jugador> {

    private Context context;
    private ArrayList<Jugador> jugadores;
    int layoutResourceId;
    public CustomAdapter(Context context, ArrayList<Jugador> jugadores) {
        super(context, 0, jugadores);

    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        Jugador jugador = getItem(i);//jugadores.get(i);

        if (view == null){
           // LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);//inflater.inflate(R.layout.row,null); // seteamos el view customizado row
        }
        TextView textoNombre = (TextView) view.findViewById(R.id.textoNombre);
        TextView textoApellido= (TextView) view.findViewById(R.id.textoApellido);
        TextView textoPosicion= (TextView) view.findViewById(R.id.textoPosicion);
        TextView textoCandidato= (TextView) view.findViewById(R.id.textoCandidato);
        textoNombre.setText(jugador.nombre);
        textoApellido.setText(jugador.apellido);
        textoPosicion.setText(jugador.posicion);
        textoCandidato.setText(jugador.candidato);
        Button bt = (Button) view.findViewById(R.id.botonEditar);
        bt.setFocusable(false);
        bt.setFocusableInTouchMode(false);
        bt.setTag(i);
        return view;
    }

}
