package com.examen.ledevin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Locale;

public class SplachScreen extends AppCompatActivity {
   private ImageView logo;
   private Intent ToActTitre;
   private BdOperations bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {bd = new BdOperations(this);
            Log.i("data","database created ");
        }catch (Exception e){
            e.printStackTrace();


        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);

        logo=(ImageView) findViewById(R.id.imgviewlogo);
       ToActTitre=  new Intent(this, EcranTitre.class);
        Animation logotransit = AnimationUtils.loadAnimation(this,R.anim.logotransit);
        logotransit.setAnimationListener( new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {


                startActivity(ToActTitre);
                finish();
            };
        });
        logo.startAnimation(logotransit);
        String b= Locale.getDefault().getDisplayLanguage();
        Log.i("langage",b);


    }
}
