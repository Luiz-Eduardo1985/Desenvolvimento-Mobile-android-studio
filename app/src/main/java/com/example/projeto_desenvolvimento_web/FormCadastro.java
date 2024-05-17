package com.example.projeto_desenvolvimento_web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormCadastro extends AppCompatActivity implements View.OnClickListener {
    EditText containerNome, containerEmail, containerCpf, containerSenha, containerConfSenha;
    Button buttonCadastrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        containerNome = (EditText) findViewById(R.id.containerNome);
        containerEmail = (EditText) findViewById(R.id.containerEmail);
        containerCpf = (EditText) findViewById(R.id.containerCpf);
        containerSenha = (EditText) findViewById(R.id.containerSenha);
        containerConfSenha = (EditText) findViewById(R.id.containerConfSenha);
        buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);

        buttonCadastrar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (validaDados()) {
            salvarDados(); //gravar dados
        }
    }

    public boolean validaDados() {
        boolean retorno = true;
        if (containerNome.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "O campo nome deve ser preenchido", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (containerCpf.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "O campo CPF deve ser preenchido", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (containerEmail.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "O campo Email deve ser preenchido", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (containerSenha.getText().length() == 0 || containerConfSenha.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Os campos de Senha devem ser preenchidos", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (!containerSenha.getText().toString().equals(containerConfSenha.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Os campos de Senha e confirma senha devem ser iguais", Toast.LENGTH_LONG).show();
            retorno = false;
        }
        return retorno;
    }
    public void salvarDados() {
        String nome =  containerNome.getText().toString();
        String email = containerEmail.getText().toString();
        String cpf = containerCpf.getText().toString();
        String senha = containerSenha.getText().toString();
        String senha2 = containerConfSenha.getText().toString();


        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereDadosUsuario(nome, cpf, email, senha);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();
        }
    public void limpar(){
        containerNome.setText("") ;
        containerEmail.setText("") ;
        containerCpf.setText("") ;
        containerSenha.setText("") ;
        containerConfSenha.setText("") ;

    }
}
