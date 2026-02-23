package com.example.formulaire;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.formulaire.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Définition des clés pour le passage de données (Bonne pratique)
    public static final String KEY_NAME = "key_name";
    public static final String KEY_EMAIL = "key_email";
    public static final String KEY_PHONE = "key_phone";
    public static final String KEY_ADDRESS = "key_address";
    public static final String KEY_CITY = "key_city";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Gestion du clic
        binding.submitBtn.setOnClickListener(v -> processForm());
    }

    private void processForm() {
        // Récupération des valeurs
        String name = binding.etName.getText().toString().trim();
        String email = binding.etEmail.getText().toString().trim();
        String phone = binding.etPhone.getText().toString().trim();
        String address = binding.etAddress.getText().toString().trim();
        String city = binding.etCity.getText().toString().trim();

        // Validation (Si Nom OU Email est vide)
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Les champs Nom et Email sont requis !", Toast.LENGTH_SHORT).show();
            return;
        }

        // Création de l'intent vers la deuxième page
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);

        // Ajout des données (Extras)
        intent.putExtra(KEY_NAME, name);
        intent.putExtra(KEY_EMAIL, email);
        intent.putExtra(KEY_PHONE, phone);
        intent.putExtra(KEY_ADDRESS, address);
        intent.putExtra(KEY_CITY, city);

        startActivity(intent);
    }
}
