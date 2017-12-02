package com.example.foodcalorie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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

        //การทำงานเมื่อ
        mSweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Path2.class);
                intent.putExtra("type", "1"); //ส่งค่าไปแอคทิวิตีปลายทาง
                startActivity(intent);
            }
        });

        mFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Path2.class);
                intent.putExtra("type", "2"); //ส่งค่าไปแอคทิวิตีปลายทาง
                startActivity(intent);
            }
        });

        mFruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Path2.class);
                intent.putExtra("type", "3"); //ส่งค่าไปแอคทิวิตีปลายทาง
                startActivity(intent);
            }
        });
    }
}

