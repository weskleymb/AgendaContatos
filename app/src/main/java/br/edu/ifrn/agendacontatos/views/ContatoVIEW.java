package br.edu.ifrn.agendacontatos.views;

import android.opengl.EGLExt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifrn.agendacontatos.daos.ContatoDAO;
import br.edu.ifrn.agendacontatos.models.Contato;

public class ContatoVIEW extends AppCompatActivity {

    private EditText etNome, etFone;
    private ListView lvListaContatos;
    private Button btInserir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_view);

        etNome = (EditText) findViewById(R.id.nome);
        etFone = (EditText) findViewById(R.id.fone);
        lvListaContatos = (ListView) findViewById(R.id.lista_contatos);
        btInserir = (Button) findViewById(R.id.inserir);

        final ContatoDAO dao = new ContatoDAO();

        ArrayAdapter<Contato> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.listarTodos());
        lvListaContatos.setAdapter(adapter);

        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contato contato = new Contato();

                contato.setNome(etNome.getText().toString());
                contato.setFone(etFone.getText().toString());

                dao.salvar(contato);

                //tvListaContatos.setText(dao.toString());

                limparFormulario();

                String mensagem = "Contato " + contato.getNome() + " salvo!";

                Toast.makeText(ContatoVIEW.this, mensagem, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void limparFormulario() {
        etNome.setText("");
        etFone.setText("");
        etNome.requestFocus();
    }


}
