package com.devhch.changeimageorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    private int[] bg = {
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3,
            R.drawable.bg4

    };

    private ImageView bg1, bg2, bg3, bg4;

    private CardView cardGo1, cardGo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bg1 = findViewById(R.id.bg1);
        bg2 = findViewById(R.id.bg2);
        bg3 = findViewById(R.id.bg3);
        bg4 = findViewById(R.id.bg4);

        cardGo1 = findViewById(R.id.cardGo1);
        cardGo1.setOnClickListener(view -> {
            changeOrderImage();

            bg1.setImageResource( bg[ 0]);
            bg2.setImageResource( bg[ 1]);
            bg3.setImageResource( bg[ 2]);
            bg4.setImageResource( bg[ 3]);
        });

        AtomicBoolean change = new AtomicBoolean(true);

        cardGo2 = findViewById(R.id.cardGo2);
        cardGo2.setOnClickListener(view -> {
            if (change.get()){

                bg = new int[]{
                        R.drawable.ic_looks_one,
                        R.drawable.ic_looks_two_,
                        R.drawable.ic_looks_3,
                        R.drawable.ic_looks_4

                };
                change.set(false);
            }else {
                bg = new int[]{
                        R.drawable.bg1,
                        R.drawable.bg2,
                        R.drawable.bg3,
                        R.drawable.bg4

                };
                change.set(true);
            }

            bg1.setImageResource( bg[ 0]);
            bg2.setImageResource( bg[ 1]);
            bg3.setImageResource( bg[ 2]);
            bg4.setImageResource( bg[ 3]);

        });
    }

    private void changeOrderImage(){

            int temp = bg[bg.length - 1];

            for (int i = bg.length - 1; i > 0; i--)
            {
                bg[i] = bg[i - 1];
            }
            bg[0] = temp;


    }
}
