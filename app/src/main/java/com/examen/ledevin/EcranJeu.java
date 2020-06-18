package com.examen.ledevin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class EcranJeu extends AppCompatActivity {
   private int nb_devin ;
    private Button btn1 ,btn2,btn3,btn4;
    private Random rand;
    private Intent ToActFin;
    private Bundle info;
    BdOperations b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_jeu);

        //info = new Bundle();
        rand = new Random();

        nb_devin = rand.nextInt(4)+1;
        //info.putInt("rand",nb_devin);

         ToActFin = new Intent(this,FinPartie.class);
         ToActFin.putExtra("guess",nb_devin);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        b = new BdOperations(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               // info.putInt("btnclick",1);
               // ToActFin.putExtra("info",info);
                ToActFin.putExtra("click",1);
                startActivity(ToActFin);
             //  b.Insert();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ToActFin.putExtra("click",2);
                startActivity(ToActFin);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ToActFin.putExtra("click",3);
                startActivity(ToActFin);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ToActFin.putExtra("click",4);
                startActivity(ToActFin);
            }
        });




    }

    @Override
    protected void onStart() {
        nb_devin = rand.nextInt(4)+1;
        super.onResume();
        super.onStart();
    }

    @Override
    protected void onStop() {
        nb_devin = rand.nextInt(4)+1;
        super.onResume();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        nb_devin = rand.nextInt(4)+1;
        super.onResume();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        rand = new Random();

        nb_devin = rand.nextInt(4)+1;
        ToActFin.putExtra("guess",nb_devin);
        super.onResume();
    }
}
