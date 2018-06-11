package com.example.charles.workingplace.Vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.Modele.Lieu;
import com.example.charles.workingplace.R;

import java.util.HashMap;
import java.util.Iterator;

public class ReserverLieu extends AppCompatActivity {

    private TextView heure;
    private TextView date;
    private Button reserver;


    Controleur controleur = new Controleur();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver_lieu);

        heure = (TextView) findViewById(R.id.InfoHeure);
        date = (TextView) findViewById(R.id.InfoDate);
        reserver = (Button) findViewById(R.id.ConfirmationReservation);



        // Objet qui me permet d'aller à l'interieur d'une liste (n'importe quel type)
        Iterator it = controleur.getLieuSelectionner().getCalendrier().entrySet().iterator();

        while(it.hasNext())
        {
            HashMap.Entry item = (HashMap.Entry)it.next();

            date.setText(item.getKey().toString());
            heure.setText(item.getValue().toString());

        }


        reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controleur.getUtilisateurCourant().getListeLieux().add(controleur.getLieuSelectionner());
                controleur.getLieuSelectionner().setStatut(true);
                ouvrirPageHome();

            }
        });


    }

    public void ouvrirPageHome(){

        Intent pageInfo = new Intent(ReserverLieu.this, Home.class);
        startActivity(pageInfo);




    }
}
