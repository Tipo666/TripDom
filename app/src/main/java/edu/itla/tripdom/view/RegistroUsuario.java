package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;


public class RegistroUsuario extends AppCompatActivity {

    private static final String LOG_T =  "Registro Usuario";

    Button btnRegistro;
    private EditText editTextNombre;
    private EditText editTextEmail;
    private EditText editTextTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //btnRegistro = (Button) findViewB
        btnRegistro = findViewById(R.id.btnBotonRegistro);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefono = findViewById(R.id.editTextTelefono);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();
                usuario.setNombre(editTextNombre.getText().toString());
                usuario.setTipoUsuario(TipoUsuario.CLIENTE);
                usuario.setEmail(editTextEmail.getText().toString());
                usuario.setTelefono(editTextTelefono.getText().toString());


                Log.i(LOG_T, usuario.toString());

            }
        });

    }
}
