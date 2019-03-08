package com.example.cris.interfacest2examen;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

public class BSplash extends AppCompatActivity {

    TextView tvTitulo;
    TextView tvSlogan;
    CircularImageView imagenCohete;
    ImageView imagenEarth;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvSlogan = findViewById(R.id.tvSlogan);
        imagenCohete = findViewById(R.id.circularImageView);
        imagenEarth = findViewById(R.id.imageEarth);

        Typeface fuente = getResources().getFont(R.font.bromello);

        //añadir fuente al titulo
        tvTitulo.setTypeface(fuente);

        Glide.with(this)
                .load(R.drawable.planetearth)
                .apply(new RequestOptions()
                        .centerCrop()
                )
                .into(imagenEarth);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);

        imagenCohete.startAnimation(myanim);
        openApp(true);
    }


    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BSplash
                        .this, BLogin.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }


}
