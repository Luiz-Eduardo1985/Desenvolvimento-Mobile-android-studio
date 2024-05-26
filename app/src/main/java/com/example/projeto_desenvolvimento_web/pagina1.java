package com.example.projeto_desenvolvimento_web;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pagina1  extends AppCompatActivity implements View.OnClickListener {

    Button cotacao, meusDados, button_sair;
    String _email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina1);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        _email = parametros.getString("email");

        cotacao.setOnClickListener(this);
        meusDados.setOnClickListener(this);
        button_sair.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()== R.id. cotacao){
            Intent tela = new Intent(this, pagina2.class);
            startActivity(tela);
        }
        if (v.getId()== R.id. button_sair){
            Intent tela = new Intent(this, formulario_login.class);
            startActivity(tela);
        }
        if (v.getId()== R.id. meusDados){
            Intent tela = new Intent(this, pagina3.class);

            Bundle parametros = new Bundle();
            parametros.putString("email", _email);
            tela.putExtras(parametros);

            startActivity(tela);
        }

    }
}
