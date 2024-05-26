package com.example.projeto_desenvolvimento_web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pagina3 extends AppCompatActivity implements View.OnClickListener {
    String _email;
    Button buttonSalvar, buttonVoltar;
    EditText meusDados_Nome, meusDados_Email, meusDados_CPF, meusDados_Senha, meusDados_ConfirmarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina3);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        _email = parametros.getString("email");

        meusDados_Nome = (EditText) findViewById(R.id.meusDados_Nome);
        meusDados_Email = (EditText) findViewById(R.id.meusDados_Email);
        meusDados_CPF = (EditText) findViewById(R.id.meusDados_CPF);
        meusDados_Senha = (EditText) findViewById(R.id.meusDados_Senha);
        meusDados_ConfirmarSenha = (EditText) findViewById(R.id.meusDados_ConfirmarSenha);
        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonVoltar = (Button) findViewById(R.id.buttonVoltar);

        buttonSalvar.setOnClickListener(this);
        buttonVoltar.setOnClickListener(this);


        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.consultaUsuario(_email) ;

        if(dados.moveToFirst()){
            meusDados_Nome.setText( dados.getString(1) );
            meusDados_Email.setText( dados.getString(2) );
            meusDados_CPF.setText( dados.getString(3) );
            meusDados_Senha.setText( dados.getString(4) );
            meusDados_ConfirmarSenha.setText( dados.getString(5) );

        }
    }

    private void BuscaDados() {
    }

    @Override
    public void onClick(View v) {

    }
}