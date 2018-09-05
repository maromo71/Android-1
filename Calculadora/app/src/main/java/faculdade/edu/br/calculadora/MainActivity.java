package faculdade.edu.br.calculadora;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtValor1, txtValor2;
    Button Somar, Subtrair, Multiplicar, Dividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Somar = findViewById(R.id.Somar);
        Subtrair = findViewById(R.id.Subtrair);
        Multiplicar = findViewById(R.id.Multiplicar);
        Dividir = findViewById(R.id.Dividir);
        txtValor1 = findViewById(R.id.txtValor1);
        txtValor2 = findViewById(R.id.txtValor2);

        //Somar
        Somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double resultado;
                Double valor1,valor2;

                valor1 = Double.parseDouble(txtValor1.getText().toString());
                valor2 = Double.parseDouble(txtValor2.getText().toString());

                resultado = valor1 + valor2 ;

                Resultado(resultado);
            }
        });
        //Subtrair
        Subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double resultado;
                Double valor1,valor2;

                valor1 = Double.parseDouble(txtValor1.getText().toString());
                valor2 = Double.parseDouble(txtValor2.getText().toString());


                resultado = valor1 - valor2 ;

                Resultado(resultado);
            }
        });
        //Multiplicar
        Multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double resultado;
                Double valor1,valor2;

                valor1 = Double.parseDouble(txtValor1.getText().toString());
                valor2 = Double.parseDouble(txtValor2.getText().toString());


                resultado = valor1 * valor2 ;

                Resultado(resultado);
            }
        });
        //Dividir
        Dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double resultado;
                Double valor1,valor2;

                valor1 = Double.parseDouble(txtValor1.getText().toString());
                valor2 = Double.parseDouble(txtValor2.getText().toString());


                resultado = valor1 / valor2 ;

                Resultado(resultado);
            }
        });


    }

    protected void Resultado(Double valor){
        AlertDialog.Builder cxDialogo = new AlertDialog.Builder(MainActivity.this);
        cxDialogo.setTitle("Resultado");
        cxDialogo.setMessage(valor.toString());
        cxDialogo.setNeutralButton("OK", null);
        cxDialogo.show();
    }
}
