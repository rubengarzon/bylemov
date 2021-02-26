package com.garzon.bylemov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pagar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);

        TextView tv1 = findViewById(R.id.tv1);
        Button btnFecha = findViewById(R.id.btnFecha);
        Button btnHora = findViewById(R.id.btnHora);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            String datos = parametros.getString("movil");
            tv1.setText(datos);
        }

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, carrito.class);
                startActivity(intent);
            }
        });

    }
}