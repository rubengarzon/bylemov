package com.garzon.bylemov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> moviles;
    private ArrayList<String> precios;
    public MyAdapter(Context context, int layout, ArrayList<String> moviles, ArrayList<String> precios){
        this.context = context;
        this.layout = layout;
        this.moviles = moviles;
        this.precios = precios;
    }

    @Override
    public int getCount() {
        return this.moviles.size();
    }

    @Override
    public Object getItem(int position) {
        return this.moviles.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v= layoutInflater.inflate(R.layout.list_moviles, null);
        // Valor actual según la posición

        String currentMovil = moviles.get(position);
        String currentPrecio = precios.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView modelo = (TextView) v.findViewById(R.id.modelo);
        TextView precio = (TextView) v.findViewById(R.id.precio);
        modelo.setText(currentMovil);
        precio.setText(currentPrecio);
        //Devolvemos la vista inflada
        return v;
    }
}
