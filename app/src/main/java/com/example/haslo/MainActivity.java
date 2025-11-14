package com.example.haslo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
        ProgressBar progress_bar = findViewById(R.id.progress_bar);
        TextView endmessage = findViewById(R.id.endmessage);

        sprawdz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int moc_hasla = 0;
                        String email_s = String.valueOf(email.getText());
                        String pass = String.valueOf(haslo.getText());
                        String pass_confirm = String.valueOf(haslo2.getText());
                        boolean czy_znaki = false;
                        boolean czy_cyfry = false;
                        boolean czy_duze = false;
                        boolean czy_male = false;
                        if (!email_s.contains("@")){
                            endmessage.setText("Niepoprawny email!");
                        }
                        else{
                            if(!pass.equals(pass_confirm) || pass.isEmpty()){
                                endmessage.setText("Niepoprawne hasło!");
                            }else{
                                if(pass.length() >= 10){
                                    moc_hasla += 1;
                                }

                                String znaki ="!@#$%^&*()_+-=?/><.";
                                for (int i = 0; i < pass.length(); i++) {
                                    if(znaki.contains(pass.charAt(i)+"")){
                                        czy_znaki = true;
                                    }
                                }if(czy_znaki){
                                    moc_hasla += 1;
                                }

                                String cyfry ="1234567890";
                                for (int i = 0; i < pass.length(); i++) {
                                    if (cyfry.contains(pass.charAt(i) + "")) {
                                        czy_cyfry = true;
                                    }
                                }if(czy_cyfry){
                                    moc_hasla += 1;
                                }

                                String uppercase ="ABCDEFGHIJKLMNOPQRSTUWXYZ";
                                for (int i = 0; i < pass.length(); i++) {
                                    if (uppercase.contains(pass.charAt(i) + "")) {
                                        czy_duze = true;
                                    }
                                }if(czy_duze){
                                    moc_hasla += 1;
                                }

                                String lowercase ="abcdefghijklmnopqrstuwxyz";
                                for (int i = 0; i < pass.length(); i++) {
                                    if (lowercase.contains(pass.charAt(i) + "")) {
                                        czy_male = true;
                                    }
                                }if(czy_male){
                                    moc_hasla += 1;
                                }
                                progress_bar.setProgress(moc_hasla);
                                if (progress_bar.getProgress() <= 2){

                                    Toast.makeText(MainActivity.this, "Twoje hasło jest całkiem słabe.", Toast.LENGTH_SHORT).show();
                                }
                                if (progress_bar.getProgress() <= 4 && progress_bar.getProgress() >= 3){

                                    Toast.makeText(MainActivity.this, "Twoje hasło jest okej.", Toast.LENGTH_SHORT).show();
                                }
                                if (progress_bar.getProgress() == 5){

                                    Toast.makeText(MainActivity.this, "Twoje hasło jest doskonałe!", Toast.LENGTH_SHORT).show();
                                }
                                endmessage.setText("Witaj "+email_s);
                            }
                        }
                    }
                }
        );
    }
}