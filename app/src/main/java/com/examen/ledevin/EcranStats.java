package com.examen.ledevin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EcranStats extends AppCompatActivity {
    TextView tvscore_recent , tvmax_score,tvmin_score,tvnb_won,tvnb_lose;
    Button btnRetour;
    Intent ToActTitre;
    AsyncDisplayTask showtask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ToActTitre = new Intent(this,EcranTitre.class);
        BdOperations dbdevin = new BdOperations(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_stats);

        tvscore_recent = findViewById(R.id.tvscore_recent);
        tvmax_score =findViewById(R.id.tvscoremax);
        tvmin_score =findViewById(R.id.tvscoremin);
        tvnb_lose =findViewById(R.id.tvnblose);
        tvnb_won =findViewById(R.id.tvnbwon);
        btnRetour = findViewById(R.id.btnretour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                startActivity(ToActTitre);
                //  b.Insert();
            }
        });
        showtask = new AsyncDisplayTask(this,tvscore_recent,tvmax_score,tvmin_score,tvnb_won,tvnb_lose);
        showtask.execute();

    }
}
