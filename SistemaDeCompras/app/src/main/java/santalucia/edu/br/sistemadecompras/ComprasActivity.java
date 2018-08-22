package santalucia.edu.br.sistemadecompras;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ComprasActivity extends AppCompatActivity {

    CheckBox chkArroz, chkCarne, chkLeite, chkFeijao, chkRefrigeirante;
    Button btnTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        chkArroz = (CheckBox)findViewById(R.id.chkArroz);
        chkLeite = (CheckBox)findViewById(R.id.chkLeite);
        chkCarne = (CheckBox)findViewById(R.id.chkCarne);
        chkFeijao =(CheckBox)findViewById(R.id.chkFeijao);
        chkRefrigeirante = (CheckBox)findViewById(R.id.chkRefrigeirante);

        btnTotal = (Button) findViewById(R.id.btnTotal);

        //Listener para o clique do botão
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0.0;
                if(chkArroz.isChecked()) total+= 2.69;
                if(chkLeite.isChecked()) total+= 5.0;
                if(chkCarne.isChecked()) total+= 9.7;
                if(chkFeijao.isChecked()) total+= 2.3;
                if(chkRefrigeirante.isChecked()) total+= 2;

                AlertDialog.Builder cxDialogo = new AlertDialog.Builder(ComprasActivity.this);
                cxDialogo.setTitle("Total em Reais");
                cxDialogo.setMessage("R$" + Double.toString(total));
                cxDialogo.setNeutralButton("OK", null);
                cxDialogo.show();


            }
        });

    }
}
