package com.garzon.bylemov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.btnIniciar);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        intentMovilesActivity(v);
    }

    public void intentMovilesActivity(View view) {
        Intent intent = new Intent(this, Moviles.class);
        startActivity(intent);
    }
}