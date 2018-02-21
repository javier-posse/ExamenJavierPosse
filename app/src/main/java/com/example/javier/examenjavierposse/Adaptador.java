package com.example.javier.examenjavierposse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Javier on 21/02/2018.
 */

public class Adaptador extends BaseAdapter {

    Context contexto;
    List<Pais> listaPaises;

    public Adaptador(Context contexto, List<Pais> listaPaises) {
        this.contexto = contexto;
        this.listaPaises = listaPaises;
    }
    @Override
    public int getCount() {
        return listaPaises.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPaises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaPaises.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista= view;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista=inflate.inflate(R.layout.pais_item, null);

        TextView nomIngl, nomCast, clave, capital, continente, poblacion, latitud, longitud, paisesFronterizos;
        nomIngl = (TextView)vista.findViewById(R.id.tvNomIngl);
        nomCast = (TextView)vista.findViewById(R.id.tvNomCast);
        clave = (TextView)vista.findViewById(R.id.tvClave);
        capital = (TextView)vista.findViewById(R.id.tvCapital);
        continente = (TextView)vista.findViewById(R.id.tvContinente);
        poblacion = (TextView)vista.findViewById(R.id.tvPoblacion);
        latitud = (TextView)vista.findViewById(R.id.tvLatitud);
        longitud = (TextView)vista.findViewById(R.id.tvLongitud);
        paisesFronterizos = (TextView)vista.findViewById(R.id.tvFronterizos);

        nomIngl.setText(listaPaises.get(i).getNombreIngles());
        nomCast.setText(listaPaises.get(i).getNombreCastellano());
        clave.setText("Clave: "+listaPaises.get(i).getClave());
        capital.setText("Capital: "+listaPaises.get(i).getCapital());
        continente.setText("Continente: "+listaPaises.get(i).getContinente());
        poblacion.setText("Población: "+listaPaises.get(i).getPoblacion());
        latitud.setText("Latitud: "+listaPaises.get(i).getLat());
        longitud.setText("Longitud: "+listaPaises.get(i).getLon());
        paisesFronterizos.setText(listaPaises.get(i).getPaisesFront());

        return vista;
    }
}
