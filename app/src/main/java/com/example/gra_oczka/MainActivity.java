package com.example.gra_oczka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Button nastepnaKarta, koniecGry;
    private ImageView losowaKarta, losowaKartaK;
    private TextView dane, danek;

    private listyKart wszystkieKarty = new listyKart();
    private int[][] listaKart = wszystkieKarty.getKartyRodzaje();
    private Random random1= new Random();
    private Random random2= new Random();

    private static int[] punktyLista = {
            2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 11
    };


    int[] mojeKarty = new int[10];
    int punkty = 0;
    int ileKart = 0;
    int punktyk = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nastepnaKarta = findViewById(R.id.nastepnaKrata);
        koniecGry = findViewById(R.id.koniecGry);
        losowaKarta = findViewById(R.id.losowaKarta);
        dane = findViewById(R.id.dane);
        danek = findViewById(R.id.danekrupiera);
        losowaKartaK = findViewById(R.id.losowaKartaKrupiera);



        nastepnaKarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                losujKarte();
                losujKarteKrupiera();
            }
        });

        koniecGry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dane.setText("Twoje punkty: " + punkty);
                danek.setText("Punkty krupiera: " + punktyk);
                nastepnaKarta.setEnabled(false);
            }
        });

    }

    public void losujKarte(){
        int numer, rodzaj;

        do{
            numer = random1.nextInt(13);
            rodzaj = random2.nextInt(4);
        }while (listaKart[numer][rodzaj] == 0);

        losowaKarta.setImageResource(listaKart[numer][rodzaj]);
        listaKart[numer][rodzaj] = 0;
        mojeKarty[ileKart] = punktyLista[numer];

        punkty += punktyLista[numer];
        dane.setText(punkty+"");
        ileKart++;
        if(punkty < 21){

            dane.setText(punkty + "");
        }else if(punkty == 21){
            dane.setText("WYGRANA" + " twoje punkty: " + punkty);
            nastepnaKarta.setEnabled(false);
        }else if(punkty > 21){
            if(punkty == 22){
                if(mojeKarty.length == 2){
                    dane.setText("WYGRANA" + " Pawie oczko");
                }else{
                    dane.setText("PRZEGRANA   " + punkty);
                    nastepnaKarta.setEnabled(false);
                }
            }else{
                dane.setText("PRZEGRANA   " + punkty);
                nastepnaKarta.setEnabled(false);
            }
        }

    }

    public void losujKarteKrupiera(){
        int numer, rodzaj;

        do{
            numer = random1.nextInt(13);
            rodzaj = random2.nextInt(4);
        }while (listaKart[numer][rodzaj] == 0);

        losowaKartaK.setImageResource(listaKart[numer][rodzaj]);
        listaKart[numer][rodzaj] = 0;
        mojeKarty[ileKart] = punktyLista[numer];

        punktyk += punktyLista[numer];
        danek.setText(punktyk+"");
        ileKart++;
        if (punktyk > 16){
            danek.setText("krupier nie może dobrać więcej kart" + punktyk);
            nastepnaKarta.setEnabled(false);
        }else if(punktyk < 21){
            danek.setText(punktyk + "");
        }else if(punktyk == 21){
            danek.setText("WYGRANA" + " Punkty krupiera: " + punktyk);
            nastepnaKarta.setEnabled(false);
        }else if(punktyk > 21){
            if(punktyk == 22){
                if(mojeKarty.length == 2){
                    danek.setText("WYGRANA" + " Pawie oczko");
                }else{
                    danek.setText("PRZEGRANA   " + punktyk);
                    nastepnaKarta.setEnabled(false);
                }
            }else{
                danek.setText("PRZEGRANA   " + punktyk);
                nastepnaKarta.setEnabled(false);
            }
        }

    }

    public void nowaGra(View view){
        listaKart = wszystkieKarty.getKartyRodzaje();
        mojeKarty = new int[10];
        punkty = 0;
        punktyk = 0;
        dane.setText("");
        danek.setText("");
        ileKart = 0;
        losowaKarta.setImageResource(R.drawable.ngscreen);
        losowaKartaK.setImageResource(R.drawable.ngscreen);
        nastepnaKarta.setEnabled(true);

    }

}