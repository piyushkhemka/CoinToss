package com.toss.piyushkhemka.cointoss;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView coin_tails = (ImageView) findViewById(R.id.imageView2);
        final ImageView coin_heads = (ImageView) findViewById(R.id.imageView1);
        final Button coin_toss = (Button) findViewById(R.id.button);
        final TextView coin_description = (TextView) findViewById(R.id.textView);
        coin_description.setText("");

        final Animation fadeout = new AlphaAnimation(1, 0);
        fadeout.setStartOffset(1000);
        fadeout.setDuration(2000);

        coin_heads.setVisibility(View.GONE);
        coin_tails.setVisibility(View.GONE);
        if (coin_description == null) throw new AssertionError();
        coin_description.setVisibility(View.GONE);
        coin_toss.setVisibility(View.VISIBLE);


        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

               // System.out.println("In Animation start block");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                coin_heads.setVisibility(View.GONE);
                coin_tails.setVisibility(View.GONE);
                coin_description.setVisibility(View.GONE);
                coin_toss.setVisibility(View.VISIBLE);
            //    System.out.println("In Animation End block");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                System.out.println("In Animation repeat block");
            }
        });


            coin_toss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Random toss = new Random();
                    int i = toss.nextInt(2);
                 //   System.out.println("In Clicking block");
                    coin_toss.setVisibility(View.GONE);
                    if (i == 0) {
                     //   System.out.println("value of i = " + i);
                        coin_tails.setVisibility(View.GONE);
                        coin_heads.setVisibility(View.VISIBLE);
                        coin_description.setText("HEADS");
                        coin_description.setVisibility(View.VISIBLE);
                        coin_heads.startAnimation(fadeout);
                        coin_description.startAnimation(fadeout);

                    } else {
                      //  System.out.println("value of i = " + i);
                        coin_tails.setVisibility(View.VISIBLE);
                        coin_description.setText("TAILS");
                        coin_description.setVisibility(View.VISIBLE);
                        coin_tails.startAnimation(fadeout);
                        coin_description.startAnimation(fadeout);

                    }
                }
            });
    }
}
