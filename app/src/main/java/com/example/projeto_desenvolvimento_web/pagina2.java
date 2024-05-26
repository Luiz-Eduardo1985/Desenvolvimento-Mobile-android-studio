package com.example.projeto_desenvolvimento_web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class pagina2 extends AppCompatActivity implements View.OnClickListener {


    Button button_voltar, button_Euro, button_libra, button_dolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina2);

        button_voltar.setOnClickListener(this);
        button_Euro.setOnClickListener(this);
        button_libra.setOnClickListener(this);
        button_dolar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId()== R.id. button_voltar){
                Intent tela = new Intent(this, pagina1.class);
                startActivity(tela);
            }
        if (v.getId()== R.id. button_Euro){
            String msg = "@string/conf_compra";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        if (v.getId()== R.id.  button_libra){
            String msg =  "@string/conf_compra";;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        if (v.getId()== R.id.  button_dolar){
            String msg =  "@string/conf_compra";;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }

    }
}