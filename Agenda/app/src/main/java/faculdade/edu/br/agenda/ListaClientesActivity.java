package faculdade.edu.br.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import faculdade.edu.br.agenda.dao.ClienteDAO;
import faculdade.edu.br.agenda.model.Cliente;

public class ListaClientesActivity extends AppCompatActivity {

    private ListView listaClientes;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        listaClientes = findViewById(R.id.listaClientes);
        listaClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cliente cli = (Cliente) listaClientes.getItemAtPosition(position);
                Intent abrirFormManut = new Intent(ListaClientesActivity.this,FormularioClienteActivity.class);
                abrirFormManut.putExtra("Cliente",cli);
                startActivity(abrirFormManut);
            }
        });
        Button btnNovo = findViewById(R.id.listacliente_btnNovo);
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irParaFormulario =  new Intent(ListaClientesActivity.this,FormularioClienteActivity.class);
                startActivity(irParaFormulario);
            }
        });
        registerForContextMenu(listaClientes);
    }
    private void carregarListaClientes() {
        ClienteDAO dao = new ClienteDAO(this);
        List<Cliente> clientes = dao.buscarClientes();
        dao.close();
        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this,android.R.layout.simple_list_item_1,clientes);
        listaClientes.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Cliente cli = (Cliente) listaClientes.getItemAtPosition(info.position);
                //Instancia de objeto
                ClienteDAO dao = new ClienteDAO(ListaClientesActivity.this);
                dao.excluir(cli);
                dao.close();
                carregarListaClientes();
                Toast.makeText(ListaClientesActivity.this,"Deletar o cliente " + cli.getNome(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        carregarListaClientes();
    }

}
