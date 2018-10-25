package faculdade.edu.br.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        Button btnNovo = findViewById(R.id.listacliente_btnNovo);
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irParaFormulario =  new Intent(ListaClientesActivity.this,FormularioClienteActivity.class);
                startActivity(irParaFormulario);
            }
        });
    }
}
