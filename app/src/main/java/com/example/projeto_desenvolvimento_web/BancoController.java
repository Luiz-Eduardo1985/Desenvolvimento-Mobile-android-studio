package com.example.projeto_desenvolvimento_web;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class BancoController {
    private SQLiteDatabase db;
    private final CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }
    public String insereDadosUsuario(String txtNome, String txtCpf, String txtEmail, String txtSenha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", txtNome);
        valores.put("cpf", txtCpf);
        valores.put("email", txtEmail);
        valores.put("senha", txtSenha);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir os dados do usuário!";
        else
            return "Dados Cadastrados com sucesso!";
    }
    public Cursor carregaDadosPeloCpfSenha(String Cpf, String senha) {
        Cursor cursor;
        String[] campos = { "idUser", "nome", "cpf","email","senha" };
        String where = "cpf ='" + Cpf +"'and senha = '"+ senha +"'";
        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
//consulta meus dados
    public Cursor consultaUsuario(String email) {
        Cursor cursor;
        String[] campos = { "idUser", "nome", "cpf","email","senha" };
        String where = "email ='" + email +"'";
        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
}