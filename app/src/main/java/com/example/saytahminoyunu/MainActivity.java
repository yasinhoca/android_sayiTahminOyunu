package com.example.saytahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText sayi;
    TextView durum,hak;
    Button gonder,tekrar;
    Random r = new Random();
    int rast,s,deneme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sayi = (EditText) findViewById(R.id.sayi);
        durum = (TextView) findViewById(R.id.tahmin);
        gonder = (Button) findViewById(R.id.gonder);
        hak = (TextView) findViewById(R.id.deneme);
        tekrar = (Button) findViewById(R.id.tekrar);
        tekrar.setEnabled(false);
        rast = Rastgele();
        deneme = 0;
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deneme++;
                s = Integer.parseInt(sayi.getText().toString());
                if(s<rast){
                    durum.setText("Daha büyük tahmin et!");
                    hak.setText(Integer.toString(deneme)+". tahmin");
                } else if(s>rast){
                    durum.setText("Daha küçük tahmin et!");
                    hak.setText(Integer.toString(deneme)+". tahmin");
                } else {
                    durum.setText("Tebrikler bildiniz!");
                    hak.setText(Integer.toString(deneme)+". tahmin");
                    gonder.setEnabled(false);
                    tekrar.setEnabled(true);
                }
            }
        });

        tekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rast = Rastgele();
                deneme = 0;
                durum.setText("");
                hak.setText("");
                tekrar.setEnabled(false);
                gonder.setEnabled(true);
            }
        });

    }

    public int Rastgele(){
        return r.nextInt(100);
    }
}