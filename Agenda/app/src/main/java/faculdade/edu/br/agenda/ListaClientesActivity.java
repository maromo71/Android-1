package faculdade.edu.br.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaClientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);

        String clientes[] = {"Antonio Carlos", "Marcos Antonio","Oscar Rodrigues","Pablo Selton"};
        ListView listaClientes = findViewById(R.id.listaClientes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,clientes);
        listaClientes.setAdapter(adapter);
    }
}
