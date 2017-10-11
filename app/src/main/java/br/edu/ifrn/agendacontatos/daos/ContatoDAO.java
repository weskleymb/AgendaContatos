package br.edu.ifrn.agendacontatos.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.agendacontatos.models.Contato;

public class ContatoDAO implements Serializable {

    private static List<Contato> contatos = new ArrayList<Contato>();

    public void salvar(Contato contato) {
        contatos.add(contato);
    }

    public List<Contato> listarTodos() {
        return contatos;
    }

    @Override
    public String toString() {
        String listaContatos = "";
        for (Contato contato : contatos) {
            listaContatos += contato.toString();
        }
        return listaContatos;
    }
}
