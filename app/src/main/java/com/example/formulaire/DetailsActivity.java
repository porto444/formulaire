package com.example.formulaire;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.formulaire.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Récupération de l'intent
        Intent receivedIntent = getIntent();
        if (receivedIntent != null) {
            displayData(receivedIntent);
        }

        // Bouton retour
        binding.backBtn.setOnClickListener(v -> finish());
    }

    private void displayData(Intent intent) {
        String name = intent.getStringExtra(MainActivity.KEY_NAME);
        String email = intent.getStringExtra(MainActivity.KEY_EMAIL);
        String phone = intent.getStringExtra(MainActivity.KEY_PHONE);
        String address = intent.getStringExtra(MainActivity.KEY_ADDRESS);
        String city = intent.getStringExtra(MainActivity.KEY_CITY);

        // Construction du texte avec StringBuilder (Change du code original)
        StringBuilder builder = new StringBuilder();

        builder.append("👤 NOM COMPLET :\n").append(name).append("\n\n");
        builder.append("📧 E-MAIL :\n").append(email).append("\n\n");

        // On affiche les champs optionnels seulement s'ils sont remplis
        // Code différent de la méthode "safe()" de l'exemple original
        appendDetail(builder, "📱 TÉLÉPHONE", phone);
        appendDetail(builder, "🏠 ADRESSE", address);
        appendDetail(builder, "📍 VILLE", city);

        binding.tvSummary.setText(builder.toString());
    }

    // Petite méthode utilitaire pour structurer le code différemment
    private void appendDetail(StringBuilder sb, String label, String value) {
        if (value != null && !value.isEmpty()) {
            sb.append(label).append(" :\n").append(value).append("\n\n");
        } else {
            sb.append(label).append(" :\nNon renseigné\n\n");
        }
    }
}
