package faculdade.edu.br.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import faculdade.edu.br.agenda.model.Cliente;

public class FormularioClienteHelper {
    private EditText campoNome;
    private EditText campoEndereco;
    private EditText campoBairro;
    private EditText campoCidade;
    private EditText campoEstado;
    private EditText campoFone;
    private EditText campoEmail;
    private RatingBar campoRating;
    private Cliente cliente;

    public FormularioClienteHelper (FormularioClienteActivity activity){
        this.cliente = new Cliente();
        campoNome = activity.findViewById(R.id.txtNome);
        campoEndereco = activity.findViewById(R.id.txtEndereco);
        campoBairro = activity.findViewById(R.id.txtBairro);
        campoCidade = activity.findViewById(R.id.txtCidade);
        campoEstado = activity.findViewById(R.id.txtEstado);
        campoFone = activity.findViewById(R.id.txtFone);
        campoEmail = activity.findViewById(R.id.txtEmail);
        campoRating = activity.findViewById(R.id.ratingNota);
    }

    public Cliente pegarCliente() {
        Cliente cli = new Cliente();

        cli.setNome(campoNome.getText().toString());
        cli.setBairro(campoBairro.getText().toString());
        cli.setCidade(campoCidade.getText().toString());
        cli.setEmail(campoEmail.getText().toString());
        cli.setEndereco(campoEndereco.getText().toString());
        cli.setEstado(campoEstado.getText().toString());
        cli.setFone(campoFone.getText().toString());
        cli.setNota(Double.valueOf(campoRating.getProgress()));

        return cli;

    }

    public void preencherFormulario(Cliente cli) {
        this.cliente = cli;
        campoNome.setText(cli.getNome());
        campoEndereco.setText(cli.getEndereco());
        campoBairro.setText(cli.getEndereco());
        campoCidade.setText(cli.getCidade());
        campoEstado.setText(cli.getEstado());
        campoFone.setText(cli.getFone());
        campoEmail.setText(cli.getEmail());
        campoRating.setProgress(cli.getNota().intValue());

    }
}
