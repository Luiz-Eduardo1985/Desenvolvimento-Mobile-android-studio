package com.example.projeto_desenvolvimento_web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class formulario_login extends AppCompatActivity implements View.OnClickListener {

    EditText containerLogEmail, containerLogSenha;
    Button buttonLog, button_cadastrar_seLog;
    String _email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_login);

        containerLogEmail =  findViewById(R.id.containerLogEmail);
        containerLogSenha =  findViewById(R.id.containerLogSenha);
        buttonLog =  findViewById(R.id.buttonLog);
        button_cadastrar_seLog =   findViewById(R.id.button_cadastrar_seLog);

        buttonLog.setOnClickListener(this);
        button_cadastrar_seLog.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.buttonLog){
            if(validaDados()){
                Intent tela = new Intent(this, pagina1.class);
                Bundle parametros = new Bundle();
                parametros.putString("email",containerLogEmail.getText().toString());
                tela.putExtras(parametros);
                startActivity(tela);

            }}
        
        if (view.getId()== R.id.button_cadastrar_seLog){

            Intent telaCadastro = new Intent(this, FormCadastro.class);

            startActivity(telaCadastro);
        }
    }
    public boolean validaDados(){
        boolean retorno  = true;
        if(containerLogEmail.getText().length()==0){
            Toast.makeText(getApplicationContext(), "O campo Email deve ser preenchido", Toast.LENGTH_LONG).show();
            retorno = false;
        } else {
            if (containerLogSenha.getText().length()==0){
                Toast.makeText(getApplicationContext(), "O campo senha deve ser preenchido", Toast.LENGTH_LONG).show();
                retorno = false;
            }else {
               BancoController bd = new BancoController(getBaseContext());

                try (Cursor dados = bd.carregaDadosPeloCpfSenha(containerLogEmail.getText().toString(), containerLogSenha.getText().toString())) {

                    if (dados.moveToFirst()) {
                        String msg = "Email / senha encontrado";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    } else {
                        String msg = "Email /senha  não encontrados";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        retorno = false;
                    }
                }
            }
        }

        return retorno;
    }
}