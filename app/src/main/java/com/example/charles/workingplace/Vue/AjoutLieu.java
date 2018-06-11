package com.example.charles.workingplace.Vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.R;

public class AjoutLieu extends AppCompatActivity {

    private EditText adresse;
    private EditText capacite;
    private EditText description;
    private Button ajoutLieu;
    private EditText ville;
    private EditText codepostal;
    private EditText date;
    private EditText heure;
    private EditText heureFin;

    private Controleur controleur = new Controleur();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_lieu);


        adresse = (EditText)findViewById(R.id.adresse);
        capacite= (EditText)findViewById(R.id.capacite);
        description = (EditText)findViewById(R.id.description);
        ajoutLieu = (Button) findViewById(R.id.ajoutLieu);
        ville = (EditText) findViewById(R.id.ville);
        codepostal = (EditText) findViewById(R.id.codepostal);
        date = (EditText) findViewById(R.id.Date);
        heure = (EditText) findViewById(R.id.Heure);
        heureFin = (EditText) findViewById(R.id.HeureFin);


        ajoutLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!adresse.getText().toString().equals("") && !ville.getText().toString().equals("")&& !codepostal.getText().toString().equals("")  && !capacite.getText().toString().equals("")){
                    controleur.creerLieu(adresse.getText().toString(),
                            ville.getText().toString(),
                            Integer.parseInt(codepostal.getText().toString()),
                            Integer.parseInt(capacite.getText().toString()),
                            description.getText().toString(),
                            date.getText().toString(),
                            heure.getText().toString(),
                            heureFin.getText().toString()


                    );
                    ouvrirPageInformation();
                }


            }
        });



    }


    public void ouvrirPageInformation(){

        Intent pageInformation = new Intent(AjoutLieu.this, Home.class);
        startActivity(pageInformation);

    }
}
