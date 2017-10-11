package br.edu.ifrn.agendacontatos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import br.edu.ifrn.agendacontatos.models.Contato;
import br.edu.ifrn.agendacontatos.views.ContatoVIEW;
import br.edu.ifrn.agendacontatos.views.R;

public class ContatoAdapter extends BaseAdapter {

    private final List<Contato> contatos;
    private Context context;

    public ContatoAdapter(Context context, List<Contato> contatos) {
        this.context = context;
        this.contatos = contatos;
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contatos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contato contato = contatos.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_contato_list, null);
        TextView item_nome = (TextView) view.findViewById(R.id.item_nome);
        TextView item_fone = (TextView) view.findViewById(R.id.item_fone);

        item_nome.setText(contato.getNome());
        item_fone.setText(contato.getFone());
        return view;
    }

}
