package com.example.javier.examenjavierposse;

import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listaPaises;
    ArrayList<Pais> lista;
    //public static final String URL = "http://restcountries.eu/rest/v2/all";
    public static final String URL = "http://192.168.31.44/Paises/paises.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPaises =(ListView)findViewById(R.id.lvPaises);

        lista= new ArrayList<Pais>();

        RequestQueue request = Volley.newRequestQueue(getApplicationContext());

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>(){

            //Cargo el Json y separo los distintos datos en sus respectivas variables de Pais
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Log.d("RESPONSE", response.toString(0));

                    JSONArray jsonArrayPrincipal = new JSONArray(response.toString(0));
                    for (int i=0;i<jsonArrayPrincipal.length();i++){

                        JSONObject jsonObjectHijo = jsonArrayPrincipal.getJSONObject(i);
                        //Creo un pais en el que cargar los datos
                        Pais p = new Pais();

                        p.setNombreIngles(jsonObjectHijo.getString("name"));
                        p.setNombreCastellano(jsonObjectHijo.getJSONObject("translations").getString("es"));
                        p.setClave(jsonObjectHijo.getString("alpha2Code"));
                        p.setCapital(jsonObjectHijo.getString("capital"));
                        p.setContinente(jsonObjectHijo.getString("region"));
                        p.setPoblacion(jsonObjectHijo.getString("population"));

                        //Si está vacío, no esntrará aquí y los pondrá en las cordenadas 0,0 HECHO PRE-PEDRO
                        if(jsonObjectHijo.getJSONArray("latlng").length()!=0){
                            p.setLat(jsonObjectHijo.getJSONArray("latlng").getString(0));
                            p.setLon(jsonObjectHijo.getJSONArray("latlng").getString(1));
                        }
                        else{
                            p.setLat("0");
                            p.setLon("0");
                        }

                        String paises="";
                        //Si estuviera vacío, no entraría en el bucle y acabaría vacío
                        for (int j=0;j<jsonObjectHijo.getJSONArray("borders").length();j++){
                            paises=paises+(jsonObjectHijo.getJSONArray("borders").getString(i));
                        }
                        p.setPaisesFront(paises);
                        p.setId(lista.size());

                        //Añado el pais a la lista de paises
                        lista.add(p);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.add(jsonArrayRequest);

        //Pongo el adaptador al listview, y le paso la lista de paises
        Adaptador adap = new Adaptador(getApplicationContext(), lista);
        listaPaises.setAdapter(adap);

        //Evento de clickado en el que abro el mapa
        listaPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Pais obj=(Pais)adapterView.getItemAtPosition(i);

                Intent inte=new Intent(getApplicationContext(), MapsActivity.class);
                //Le paso los distintos datos al mapa
                inte.putExtra("latitud", (Serializable)obj.getLat());
                inte.putExtra("longitud", (Serializable)obj.getLon());
                inte.putExtra("pais", (Serializable)obj.getNombreCastellano());
                inte.putExtra("capital", (Serializable)obj.getCapital());
                inte.putExtra("poblacion", (Serializable)obj.getPoblacion());
                startActivity(inte);
            }
        });
    }
}
