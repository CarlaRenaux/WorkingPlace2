package com.example.charles.workingplace.Vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.Modele.Etudiant;
import com.example.charles.workingplace.Modele.Professionel;
import com.example.charles.workingplace.R;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {

    private TextView bienvenue;
    private Button infoButton;
    private Button mapButton;
    private Button creerLieu;
    private Button deconnexion;
    private TextView explication;


    private Controleur controleur = new Controleur();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bienvenue = (TextView) findViewById(R.id.texteBienvenue);
        infoButton =(Button) findViewById(R.id.infoBouton);
        mapButton = (Button) findViewById(R.id.mapButton);
        creerLieu = (Button) findViewById(R.id.creerLieu);
        deconnexion = (Button) findViewById(R.id.deconnexion);
        explication = (TextView) findViewById(R.id.explication);

        deconnexion.setVisibility(View.INVISIBLE);
        infoButton.setVisibility(View.INVISIBLE);

        deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                controleur.setUtilisateurCourant(null);
                ouvrirPageMain();

            }
        });

        bienvenue.setText("Bonjour " +controleur.getUtilisateurCourant().recupererPrenom());

        if(controleur.getUtilisateurCourant() instanceof Professionel){

            explication.setText("Tu as une pièce chez toi qui ne te sert pas ? Tu souhaites en faire profiter des étudiants qui eux, font la queue pendant des heures à la bibliothèque ? Alors, rentre l'adresse que tu veux et invite-les dans un endroit convivial et chaleureux.");


        }

        if(controleur.getUtilisateurCourant() instanceof Etudiant)

        {
            creerLieu.setVisibility(View.INVISIBLE);
        }



        creerLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirPageLieu();
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ouvrirPageInfo();


            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ouvrirPageMap();


            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()) {
            case R.id.item_deconnexion:
                ouvrirPageMain();
                break;
            case R.id.item_info_perso:
                ouvrirPageInfo();
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    public void ouvrirPageInfo(){

        Intent pageInfo = new Intent(Home.this, Information.class);
        startActivity(pageInfo);




    }

    public void ouvrirPageMain(){

        Intent pageMain = new Intent(Home.this, MainActivity.class);
        startActivity(pageMain);




    }

    public void ouvrirPageMap(){

        Intent pageInfo = new Intent(Home.this, MapsActivity.class);
        startActivity(pageInfo);




    }

    public void ouvrirPageLieu(){

        Intent pageLieu = new Intent(Home.this, AjoutLieu.class);
        startActivity(pageLieu);




    }
}
