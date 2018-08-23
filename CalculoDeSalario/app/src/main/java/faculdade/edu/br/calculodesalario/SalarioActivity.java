package faculdade.edu.br.calculodesalario;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SalarioActivity extends AppCompatActivity {

   RadioGroup radioGroupo;
   Button btnCalcular;
   EditText txtSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        txtSalario = findViewById(R.id.editSalario);
        radioGroupo = findViewById(R.id.radioGrupo);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario = Double.parseDouble(txtSalario.getText().toString());
                int opcao = radioGroupo.getCheckedRadioButtonId();
                if(opcao == R.id.radio40) salario *= 1.40;
                if(opcao == R.id.radio45) salario *= 1.45;
                if(opcao == R.id.radio50) salario *= 1.45;
                AlertDialog.Builder cxDialogo = new AlertDialog.Builder(SalarioActivity.this);

                cxDialogo.setTitle("Resultado");
                cxDialogo.setMessage("Novo salário: " + Double.toString(salario));
                cxDialogo.setNeutralButton("OK",null);
                cxDialogo.show();
            }
        });
    }
}
