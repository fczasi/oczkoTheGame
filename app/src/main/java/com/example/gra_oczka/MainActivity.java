package com.example.gra_oczka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button nastepnaKarta, koniecGry;
    private ImageView losowaKarta;
    private TextView dane;

    private int[][] naRodzaje = {

            {
                    R.drawable.karo2,
                    R.drawable.kier2,
                    R.drawable.trefl2,
                    R.drawable.pik2
            },
            {R.drawable.karo3,
                    R.drawable.kier3,
                    R.drawable.trefl3,
                    R.drawable.pik3,
            },
            {R.drawable.karo4,
                    R.drawable.kier4,
                    R.drawable.trefl4,
                    R.drawable.pik4,
            },
            {R.drawable.karo5,
                    R.drawable.kier5,
                    R.drawable.trefl5,
                    R.drawable.pik5,
            },
            {R.drawable.karo6,
                    R.drawable.kier6,
                    R.drawable.trefl6,
                    R.drawable.pik6,
            },
            {R.drawable.karo7,
                    R.drawable.kier7,
                    R.drawable.trefl7,
                    R.drawable.pik7,
            },
            {R.drawable.karo7,
                    R.drawable.kier7,
                    R.drawable.trefl7,
                    R.drawable.pik7,
            },
            {R.drawable.karo8,
                    R.drawable.kier8,
                    R.drawable.trefl8,
                    R.drawable.pik8,
            },
            {R.drawable.karo9,
                    R.drawable.kier9,
                    R.drawable.trefl9,
                    R.drawable.pik9,
            },
            {R.drawable.karo10,
                    R.drawable.kier10,
                    R.drawable.trefl10,
                    R.drawable.pik10,
            },
            {R.drawable.karojopek,
                    R.drawable.kierjopek,
                    R.drawable.trefljopek,
                    R.drawable.pikjopek,
            },
            {R.drawable.karokrolowa,
                    R.drawable.kierkrolowa,
                    R.drawable.treflkrolowa,
                    R.drawable.pikkrolowa,
            },
            {R.drawable.karokrol,
                    R.drawable.kierkrol,
                    R.drawable.treflkrol,
                    R.drawable.pikkrol,
            },
            {R.drawable.karoas,
                    R.drawable.kieras,
                    R.drawable.treflas,
                    R.drawable.pikas,
            }

    };
    private int[] punkty = {
            2,3,4,5,6,7,8,9,10,2,3,4,11
    };

    private int[][] listaKart;
    private int punktyGracza = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaKart = naRodzaje;

        Random random= new Random();

        nastepnaKarta = findViewById(R.id.nastepnaKrata);
        koniecGry = findViewById(R.id.koniecGry);
        losowaKarta = findViewById(R.id.losowaKarta);
        dane = findViewById(R.id.dane);

        nastepnaKarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int losowa = -1;
                int iloscZuzytych = 0;
                do{
                    losowa = random.nextInt(listaKart.length);
                }while(listaKart[losowa] < 0);
                for(int i = 0; i < listaKart.length; i++){
                    if(listaKart(i) < 0){
                        iloscZuzytych++;
                    }
                }
                /*if(iloscZuzytych >= listaKart.length - 1){
                    losowaKarta.setImageResource(R.drawable.joker1);
                }else{
                    losowaKarta.setImageResource(listaKart[losowa]);
                    listaKart[losowa] = -1;
                }*/
            }
        });

        koniecGry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int losowa = -1;
                int iloscZuzytych = 0;
                int numer, rodzaj;
                do{
                    numer = random.nextInt(14);
                    rodzaj = random.nextInt(5);
                }while(listaKart[numer][rodzaj] < 0);
                losowaKarta.setImageResource(listaKart[numer][rodzaj]);
                iloscZuzytych++;
                punktyGracza += punkty[numer];
                dane.setText(punktyGracza);
            }
        });


    }
}




/*
Karty 2 do 10 mają wartość równą wartości karty
walet – 2 pkt.
dama – 3 pkt.
król – 4 pkt.
As – 11 pkt.
 */