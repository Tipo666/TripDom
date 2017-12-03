package edu.itla.tripdom.view.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Tipo666 on 12/3/2017.
 */

public class UsuarioListAdapter extends BaseAdapter {

    private Activity context;
    List<Usuario> usuarios;

    public UsuarioListAdapter(Activity context, List<Usuario> usuarios) {
        this.usuarios = usuarios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){

        if(view == null){
            LayoutInflater inteflater = context.getLayoutInflater();
            view = inteflater.inflate(R.layout.listview_usuarios_row, null, true);

        }

        TextView lvNombre = view.findViewById(R.id.lvNombreUsuario);
        TextView lvEmail = view.findViewById(R.id.lvEmail);
        TextView lvTipoUsuario = view.findViewById(R.id.lvTipoUsuario);

        Usuario u = usuarios.get(i);

        lvNombre.setText(u.getNombre());
        lvEmail.setText(u.getEmail());
        lvTipoUsuario.setText(u.getTipoUsuario().toString());

        return view;
    }


}
