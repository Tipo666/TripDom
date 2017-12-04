package edu.itla.tripdom.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.itla.tripdom.R;

public class Menu extends AppCompatActivity {

    private Button btnUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnUsuario = findViewById(R.id.btnUsuarios);

        btnUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, RegistroUsuario.class);
                startActivity(intent);
            }
        });
    }
}
