package com.examen.ledevin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinPartie extends AppCompatActivity {
   private Button btnrejouer, btnmenu;
   private Intent ToActMenu , ToActJeu;
   private TextView guesstxt , selecttxt;
   private ImageView imgconsequence ;
   private int numberclick , numberguess;
   private static int  score;
   private BdOperations dbdevin;
   private boolean iswon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ToActMenu = new Intent(this,EcranTitre.class);
        ToActJeu = new Intent(this,EcranJeu.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_partie);

        dbdevin = new BdOperations(this);
        numberguess= getIntent().getIntExtra("guess",0);


        numberclick=getIntent().getIntExtra("click",0);
        btnrejouer = findViewById(R.id.btnRejouer);
        btnmenu = findViewById(R.id.btnmenu);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // info.putInt("btnclick",1);
                // ToActFin.putExtra("info",info);

                startActivity(ToActMenu);
            }
        });
        btnrejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // info.putInt("btnclick",1);
                // ToActFin.putExtra("info",info);

                startActivity(ToActJeu);
            }
        });
        imgconsequence =(ImageView) findViewById(R.id.imgconsequence);
        guesstxt =(TextView) findViewById(R.id.tvdeviner);
        selecttxt = (TextView) findViewById(R.id.tvselectioné);
       // gonnaget = findViewById(R.id.tvscore);
        String guess= guesstxt.getText().toString();
        String select= selecttxt.getText().toString();
        guesstxt.setText(guess+" : "+numberguess);
        selecttxt.setText(select+" : "+numberclick);

        if(numberguess==numberclick){
            iswon=true;

            imgconsequence.setImageResource(R.drawable.gagne);
        }else {
            iswon=false;
            imgconsequence.setImageResource(R.drawable.perdu);
        }

       Thread get_update = new Thread(new Runnable() {
            @Override
            public void run() {
                Stats stat ;
             stat = dbdevin.getAllData();
             dbdevin.updateData(iswon,stat);

            }
        });
        get_update.start();
        Stats stat = dbdevin.getAllData();

       // gonnaget.setText(""+stat.getScore_recent());

    }


}
