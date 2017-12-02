package com.example.foodcalorie;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.R.attr.type;


public class MainActivity extends AppCompatActivity {

    private ImageButton mSweetButton;
    private ImageButton mFoodButton;
    private ImageButton mFruitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSweetButton = (ImageButton) findViewById(R.id.sweet_button);
        mFoodButton = (ImageButton) findViewById(R.id.food_button);
        mFruitButton = (ImageButton) findViewById(R.id.fruit_button);

        mSweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Path2.class);
               // String type = "1";
                intent.putExtra("type","1");
                startActivity(intent);

            }
        });

        mFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Path2.class);
                intent.putExtra("type","2");
                startActivity(intent);


            }
        });

        mFruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Path2.class);
                intent.putExtra("type","3");
                startActivity(intent);

            }
        });



    }






    }

