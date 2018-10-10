package faculdade.edu.br.listadecontatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListaDeContatosActivity extends AppCompatActivity {

    ListView listaContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_contatos);

        listaContatos = findViewById(R.id.listaContatos);

        listaContatos.setOnItemClickListener((AdapterView,view));
    }
}
