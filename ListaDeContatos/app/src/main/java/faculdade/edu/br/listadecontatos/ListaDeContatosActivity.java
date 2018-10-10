package faculdade.edu.br.listadecontatos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaDeContatosActivity extends AppCompatActivity {

    ListView listaContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_contatos);

        listaContatos = findViewById(R.id.listaContatos);
        listaContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nome = ((TextView) view).getText().toString();
                AlertDialog.Builder dialogo = new AlertDialog.Builder(ListaDeContatosActivity.this);
                dialogo.setTitle("Contato");
                dialogo.setMessage("Contato selecionado: " + nome);
                dialogo.setNegativeButton("OK",null);
                dialogo.show();
            }
        });
    }
}
