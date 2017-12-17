package edu.itla.tripdom.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.UsuarioActual;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.Usuario;
import edu.itla.tripdom.view.listadapter.UsuarioListAdapter;

public class ListaUsuario extends AppCompatActivity {

    private static final String LOG_T = ListaUsuario.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        final UsuarioDbo usuarioDbo = new UsuarioDbo(this);
        final List<Usuario> usuarios = usuarioDbo.buscar();

        Log.i(LOG_T, "Cantidad de usuario" + usuarios.size());
        ListView listView = findViewById(R.id.listaUsuario);
        listView.setAdapter(new UsuarioListAdapter(this, usuarios));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Usuario u = (Usuario)adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ListaUsuario.this, RegistroUsuario.class);
                intent.putExtra("usuario", u);

                startActivity(intent);

                //Usuario u = new Usuario()
            }
        });

        Button btnAgregar = findViewById(R.id.agregarUsuario);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaUsuario.this, RegistroUsuario.class);
                startActivity(intent);
            }
        });
    }
}
