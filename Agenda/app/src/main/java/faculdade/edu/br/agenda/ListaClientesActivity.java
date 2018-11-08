package faculdade.edu.br.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import faculdade.edu.br.agenda.dao.ClienteDAO;
import faculdade.edu.br.agenda.model.Cliente;

public class ListaClientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        ClienteDAO dao = new ClienteDAO(this);
        List<Cliente> clientes = dao.buscarClientes();
        ListView listaClientes = findViewById(R.id.listaClientes);
        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this,android.R.layout.simple_list_item_1,clientes);
        listaClientes.setAdapter(adapter);
        carregarListaClientes();
        Button btnNovo = findViewById(R.id.listacliente_btnNovo);
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irParaFormulario =  new Intent(ListaClientesActivity.this,FormularioClienteActivity.class);
                startActivity(irParaFormulario);
            }
        });
    }
    private void carregarListaClientes() {
        ClienteDAO dao = new ClienteDAO(this);
        List<Cliente> clientes = dao.buscarClientes();
        dao.close();

        ListView listaClientes = findViewById(R.id.listaClientes);
        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this,android.R.layout.simple_list_item_1,clientes);
        listaClientes.setAdapter(adapter);
    }
    @Override
    protected void onResume(){
        super.onResume();
        carregarListaClientes();
    }

}
