package com.examen.ledevin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EcranTitre extends AppCompatActivity {
    private Button btnjouer,btnstats;
    private Intent ToActJeu , ToActStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_titre);
        btnjouer = (Button) findViewById(R.id.jouerBtn);

        btnstats = (Button) findViewById(R.id.StatsBtn);
        ToActJeu = new Intent(this,EcranJeu.class);
        ToActStats = new Intent(this,EcranStats.class);
        btnjouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(ToActJeu);
            }
        });
        btnstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(ToActStats);
            }
        });

    }


}
