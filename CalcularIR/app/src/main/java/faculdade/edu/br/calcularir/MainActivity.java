package faculdade.edu.br.calcularir;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText editSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        editSalario = findViewById(R.id.editSalario);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario = Double.parseDouble(editSalario.getText().toString());
                AlertDialog.Builder cxDialogo = new AlertDialog.Builder(MainActivity.this);
                cxDialogo.setTitle("Resultado");
                cxDialogo.setMessage(calcularImposto(salario).toString());
                cxDialogo.setNeutralButton("OK", null);
                cxDialogo.show();
            }
        });
    }

    private String calcularImposto(double salario){
        double valorImposto, salarioLiquido;
        StringBuilder mensagem = new StringBuilder();

        if(salario < 1257.12) {
            mensagem.append("Isento de IR");
            return mensagem.toString();
        }

        if(salario >= 1257.12 && salario <= 2510) {
            valorImposto = salario * 0.17;
            salarioLiquido = salario - valorImposto;

            mensagem.append("Salario bruto: " + Double.toString(salario));
            mensagem.append("\n");
            mensagem.append("Valor do imposto: " + Double.toString(valorImposto));
            mensagem.append("\n");
            mensagem.append("Salario Liquido: " + Double.toString(salarioLiquido));
            mensagem.append("\n");
            return mensagem.toString();
        }

        if(salario >= 2510 ){
            valorImposto = salario * 0.28;
            salarioLiquido = salario - valorImposto;

            mensagem.append("Salario bruto: " + Double.toString(salario));
            mensagem.append("\n");
            mensagem.append("Valor do imposto: " + Double.toString(valorImposto));
            mensagem.append("\n");
            mensagem.append("Salario Liquido: " + Double.toString(salarioLiquido));
            mensagem.append("\n");
            return mensagem.toString();
        }

        mensagem.append("Erro");
        return mensagem.toString();
    };
}
