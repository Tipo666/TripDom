package edu.itla.tripdom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    final static int HOLA = 2;

    private Button btn1;
    private EditText editText;
    private TextView txtVisualizarNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnBoton1);
        editText =  findViewById(R.id.editText);
        txtVisualizarNombre = findViewById(R.id.txtVisualizarNombre);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visualizar = new Intent(MainActivity.this, Visualizar.class);
                visualizar.putExtra("Nombre", editText.getText().toString());
                startActivity(visualizar);

            //    Toast mensaje = Toast.makeText(MainActivity.this, " " + editText.getText(), Toast.LENGTH_SHORT);
              //  mensaje.show();
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
