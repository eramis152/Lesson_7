package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0; // Variable para contar los clics
    private TextView mShowCount; // TextView para mostrar el contador

    // Clave para almacenar el contador en el estado de la instancia
    private static final String STATE_COUNT = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar los elementos de la UI
        Button buttonToast = findViewById(R.id.button_toast);
        Button buttonCount = findViewById(R.id.button_count);
        mShowCount = findViewById(R.id.show_count);

        // Restaurar el estado guardado si existe
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(STATE_COUNT, 0);
            mShowCount.setText(String.valueOf(mCount));
        }

        // Configurar el botón para mostrar un mensaje tipo Toast
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello Toast", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar el botón para incrementar el contador
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                mShowCount.setText(String.valueOf(mCount));
            }
        });
    }

    // Guardar el estado de la instancia
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNT, mCount);
    }
}
