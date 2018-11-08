package faculdade.edu.br.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import faculdade.edu.br.agenda.model.Cliente;

public class ClienteDAO extends SQLiteOpenHelper {


    public ClienteDAO(Context context) {
        super(context, "Clientes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Clientes (id INT PRIMARY KEY, " +
                "nome TEXT," +
                "endereco TEXT," +
                "bairro TEXT,"+
                "cidade TEXT,"+
                "estado TEXT," +
                "fone TEXT," +
                "email TEXT," +
                "nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Clientes";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("nome",cliente.getNome());
        dados.put("endereco",cliente.getEndereco());
        dados.put("bairro",cliente.getBairro());
        dados.put("cidade",cliente.getCidade());
        dados.put("estado",cliente.getEstado());
        dados.put("fone",cliente.getFone());
        dados.put("email",cliente.getEmail());
        dados.put("nota", cliente.getNota());
        db.insert("Clientes",null,dados);
    }

    public List<Cliente> buscarClientes() {
        String sql = "SELECT * FROM Clientes;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Cliente> clientes = new ArrayList<Cliente>();
        while(c.moveToNext()){
            Cliente cli = new Cliente();
            cli.setId(c.getLong(c.getColumnIndex("id")));
            cli.setNome(c.getString(c.getColumnIndex("nome")));
            cli.setEndereco(c.getString(c.getColumnIndex("endereco")));
            cli.setBairro(c.getString(c.getColumnIndex("bairro")));
            cli.setCidade(c.getString(c.getColumnIndex("cidade")));
            cli.setEstado(c.getString(c.getColumnIndex("estado")));
            cli.setFone(c.getString(c.getColumnIndex("fone")));
            cli.setEmail(c.getString(c.getColumnIndex("email")));
            cli.setNota(c.getDouble(c.getColumnIndex("nota")));
            clientes.add(cli);
        }
        c.close();
        return clientes;
    }
}
