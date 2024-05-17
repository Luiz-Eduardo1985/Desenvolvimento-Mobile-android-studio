package com.example.projeto_desenvolvimento_web;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco_exemplo.db";
    private static final int VERSAO = 2;
    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {

        String sql = "CREATE TABLE usuarios ("
                + "idUser integer primary key autoincrement,"
                + "nome text,"
                + "cpf text,"
                + "email text,"
                + "senha text)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}