package faculdade.edu.br.calcularidadeaproximada;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnEnviar);
        datePicker = findViewById(R.id.datePicker);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int dia, mes, ano, idadeAproximada;

            dia = datePicker.getDayOfMonth();
            mes = datePicker.getMonth();
            ano = datePicker.getYear();

            idadeAproximada = calcularIdade(dia, mes, ano);

            AlertDialog.Builder cxDialogo = new AlertDialog.Builder(MainActivity.this);
            cxDialogo.setTitle("Resultado");
            cxDialogo.setMessage("Sua idade aproximada é: " + idadeAproximada + " anos.");
            cxDialogo.setNeutralButton("OK", null);
            cxDialogo.show();

            }
        });

    }

    public int calcularIdade(int Dia,int Mes,int Ano) {

        // Data de hoje.
        GregorianCalendar hoje = new GregorianCalendar();
        int diaHoje = hoje.get(Calendar.DAY_OF_MONTH);
        int mesHoje = hoje.get(Calendar.MONTH) + 1;
        int anoHoje = hoje.get(Calendar.YEAR);

        // Data do nascimento.
        int diaNascimento = Dia;
        int mesNascimento = Mes;
        int anoNascimento = Ano;

        // Idade.
        int idade;

        if (mesNascimento < mesHoje || (mesNascimento == mesHoje && diaNascimento <= diaHoje))
            idade = anoHoje - anoNascimento;
        else
            idade = (anoHoje - anoNascimento)-1;

        return (idade);
    }
}
