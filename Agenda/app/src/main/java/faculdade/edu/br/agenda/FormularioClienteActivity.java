package faculdade.edu.br.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import faculdade.edu.br.agenda.dao.ClienteDAO;
import faculdade.edu.br.agenda.model.Cliente;

public class FormularioClienteActivity extends AppCompatActivity {

    private FormularioClienteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cliente);
        helper = new FormularioClienteHelper(this);
        Intent intent = getIntent();
        Cliente cli = (Cliente) intent.getSerializableExtra("Cliente");
        if(cli != null){
            helper.preencherFormulario(cli);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario_cliente,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Cliente cliente = helper.pegarCliente();
                ClienteDAO dao = new ClienteDAO(this);
                if(cliente.getId() !=null){
                    dao.alterar(cliente);
                }else{
                    dao.inserir(cliente);
                }
                dao.close();
                Toast.makeText(FormularioClienteActivity.this,"Cliente " + cliente.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
