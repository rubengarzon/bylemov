package com.garzon.bylemov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Moviles extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviles);

        ListView listaMoviles = findViewById(R.id.listaMoviles);

        ArrayList<String> moviles = new ArrayList<String>();
        moviles.add("SAMSUNG A51");
        moviles.add("APPLE iPhone 12");
        moviles.add("OPPO A52");
        moviles.add("OPPO Find X2 Lite");
        moviles.add("SAMSUNG Galaxy A41");
        moviles.add("XIAOMI Redmi Note 9 Pro");

        ArrayList<String> listaPrecios = new ArrayList<String>();
        listaPrecios.add("250€");
        listaPrecios.add("400€");
        listaPrecios.add("330€");
        listaPrecios.add("180€");
        listaPrecios.add("310€");
        listaPrecios.add("230€");

        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_moviles, moviles, listaPrecios);
        listaMoviles.setAdapter(myAdapter);

        listaMoviles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Moviles.this);

                builder.setTitle("Comprar móvil: " + moviles.get(position));
                builder.setMessage("Aceptar para continuar, o cancelar para parar: ");

                builder.setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Create the text message with a string
                        Intent sendIntent = new Intent(Moviles.this, Pagar.class);
                        sendIntent.putExtra("movil", moviles.get(position));
                        sendIntent.setType("text/plain");

                        if (sendIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(sendIntent);
                        }
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

                builder.show();
            }

        });

        listaMoviles.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listaMoviles.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_carro:
                        Intent intent = new Intent(Moviles.this, Carrito.class)
                        ;
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                return false;
            }
        });



    }

}

