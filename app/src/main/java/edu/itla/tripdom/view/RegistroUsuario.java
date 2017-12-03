package edu.itla.tripdom.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.Visualizar;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;


public class RegistroUsuario extends AppCompatActivity {

    private static final String LOG_T =  "Registro Usuario";

    private Button btnRegistro;
    private Button btnListar;
    private EditText editTextNombre;
    private EditText editTextEmail;
    private EditText editTextTelefono;

    private UsuarioDbo usuarioDbo = new UsuarioDbo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        btnRegistro = findViewById(R.id.btnBotonRegistro);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        btnListar = findViewById(R.id.btnListar);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent visualizar = new Intent(RegistroUsuario.this, Visualizar.class);
               // visualizar.putExtra("Nombre", editText.getText().toString());
                startActivity(visualizar);

                /*
                List<Usuario> usuarios = usuarioDbo.buscar();

                for (Usuario u: usuarios){
                    Log.i("ListUsuarios", u.toString());
                }*/
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();
                usuario.setNombre(editTextNombre.getText().toString());
                usuario.setTipoUsuario(TipoUsuario.CLIENTE);
                usuario.setEmail(editTextEmail.getText().toString());
                usuario.setTelefono(editTextTelefono.getText().toString());

                usuarioDbo.crear(usuario);

                //Log.i(LOG_T, usuario.toString());

            }
        });

    }
}
