package com.garzon.bylemov;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Carrito extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        ListaMovilesComprados listaMoviles = new ListaMovilesComprados();

        LinearLayout linearLayout = findViewById(R.id.LinearLayout);

        if(listaMoviles.getMovilesList().size()>0){
            for (int i = 0; i <listaMoviles.getMovilesList().size(); i++) {

                Toast.makeText(this, "entroooo", Toast.LENGTH_SHORT).show();
                TextView textView = new TextView(this);

                textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setTextSize(20);
                textView.setTextColor(Color.parseColor("white"));
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setText(listaMoviles.getMovilesList().get(i));

                Toast.makeText(getApplicationContext(), "Articulo: " + listaMoviles.getMovilesList().get(i), Toast.LENGTH_LONG).show();

                textView.setId(View.generateViewId());
                linearLayout.addView(textView);

            }
        }else{
            Toast.makeText(this, "No tienes ningún móvil en el carrito", Toast.LENGTH_SHORT).show();
        }

        //recupera el estado
        if(savedInstanceState != null){
            Toast.makeText(getApplicationContext(), "Restableciendo estado", Toast.LENGTH_LONG).show();
            for (int i = 0; i < listaMoviles.getMovilesList().size(); i++) {
                listaMoviles.getMovilesList().get(i);
            }
        }
    }

    public void onSaveInstanceState(Bundle estado){
        ListaMovilesComprados listaMoviles = new ListaMovilesComprados();
        estado.putStringArrayList("movilescomprados", listaMoviles.getMovilesList());
        super.onSaveInstanceState(estado);
    }

    }
