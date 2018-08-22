package santalucia.br.olamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OlaActivity extends AppCompatActivity {

    //Aqui somente é definido
    TextView txtMsg;
    Button btnAcao;
    Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ola);

        //Associar aos controles no XML Activity
        txtMsg =  (TextView)findViewById(R.id.txtMsg);
        btnAcao = (Button) findViewById(R.id.btnAcao);
        btnFechar = (Button)findViewById(R.id.btnFechar);

        btnAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMsg.setText("Você clicou!");
            }
        });

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
