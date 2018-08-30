package faculdade.edu.br.calculoimc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText editPeso, editAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double imc, altura, peso;
                String mensagem = "";

                altura = Double.parseDouble(editAltura.getText().toString());
                peso = Double.parseDouble(editPeso.getText().toString());

                imc = peso /(altura * altura);

                if(imc < 18.5) mensagem = "Você está abaixo do peso ideal!";
                if(imc >= 18.5 && imc <= 24.9 ) mensagem = "Parabéns! Você está no peso ideal!";
                if(imc >=25 && imc <=29.9) mensagem = "Você está acima do peso(sobrepeso)!";
                if(imc >= 30 && imc <=34.9) mensagem = "Obesidade Grau I";
                if(imc >= 35 && imc <= 39.9) mensagem = "Obesidade Grau II";
                if(imc >= 40) mensagem = "YOU DIED";

                AlertDialog.Builder caixaDialogo = new AlertDialog.Builder(MainActivity.this);
                caixaDialogo.setTitle("IMC");
                caixaDialogo.setMessage(mensagem);
                caixaDialogo.setNeutralButton("OK",null);
                caixaDialogo.show();
            }
        });
    }
}
