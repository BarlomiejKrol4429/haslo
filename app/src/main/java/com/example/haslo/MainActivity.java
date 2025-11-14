package com.example.haslo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText email = findViewById(R.id.email);
        EditText haslo = findViewById(R.id.haslo);
        EditText haslo2 = findViewById(R.id.haslo2);
        Button sprawdz = findViewById(R.id.sprawdz);

        sprawdz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String email_s = String.valueOf(email.getText());
                        String pass = String.valueOf(haslo.getText());
                        String pass_confirm = String.valueOf(haslo2.getText());

                        if (!email_s.contains("@")){
                            Toast.makeText(MainActivity.this, "Niepoprawny email!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if(!pass.equals(pass_confirm)){
                                Toast.makeText(MainActivity.this, "Niepoprawne hasło!", Toast.LENGTH_SHORT).show();
                            }else{

                            }
                        }
                    }
                }
        );
    }
}