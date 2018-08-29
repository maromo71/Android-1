package faculdade.edu.br.calculocotacaodolar;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtValorReal;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorReal = findViewById(R.id.txtValorReal);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double valor, real, dolar;

                real = Double.parseDouble(txtValorReal.getText().toString());
                dolar = 4.11;

                valor = real * dolar;

                AlertDialog.Builder cxDialogo = new AlertDialog.Builder(MainActivity.this);

                cxDialogo.setTitle("Valor em dolar $");
                cxDialogo.setMessage("$ " + Double.toString(valor));
                cxDialogo.setNeutralButton("OK",null);
                cxDialogo.show();
            }
        });
    }
}
