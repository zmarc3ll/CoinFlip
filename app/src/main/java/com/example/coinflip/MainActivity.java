package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ImageView coinsPlace;
    private Button fejGomb;
    private Button irasGomb;
    private TextView dobasokText;
    private TextView gyozelemText;
    private TextView veresegtext;
    private int tipp;
    private Random rnd;
    private int dobasokSzama;
    private int gyozelmekSzama;
    private int veresegekSzama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();
        jatekVege();
    }

    private void init() {
        coinsPlace =findViewById(R.id.coinsPlace);
        fejGomb = findViewById(R.id.fejGomb);
        irasGomb=findViewById(R.id.irasGomb);
        dobasokText=findViewById(R.id.dobasokText);
        gyozelemText=findViewById(R.id.gyozelemtext);
        veresegtext = findViewById(R.id.veresegText);
        tipp=-1;
        dobasokSzama=0;
        gyozelmekSzama=0;
        veresegekSzama=0;
    }

    private void addListeners() {
        fejGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp=1;
                rnd=new Random();
                dobasokSzama++;
                dobasokText.setText("Dobások: "+dobasokSzama);
                int randomGen=rnd.nextInt(2);
                if (randomGen==tipp) {
                    coinsPlace.setImageResource(R.drawable.heads);
                    gyozelmekSzama++;
                    gyozelemText.setText("Győzelem: "+gyozelmekSzama);
                } else {
                    coinsPlace.setImageResource(R.drawable.tails);
                    veresegekSzama++;
                    veresegtext.setText("Vereség: "+veresegekSzama);
                }
            }
        });
        irasGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp=0;
                rnd=new Random();
                dobasokSzama++;
                dobasokText.setText("Dobások: "+dobasokSzama);
                int randomGen=rnd.nextInt(2);
                if (randomGen==tipp) {
                    coinsPlace.setImageResource(R.drawable.tails);
                    gyozelmekSzama++;
                    gyozelemText.setText("Győzelem: "+gyozelmekSzama);
                } else {
                    coinsPlace.setImageResource(R.drawable.heads);
                    veresegekSzama++;
                    veresegtext.setText("Vereség: "+veresegekSzama);
                }
            }
        });

    }
    private void jatekVege() {
        if (dobasokSzama<=5) {
            //TODO felugró ablak...
        }
    }



}