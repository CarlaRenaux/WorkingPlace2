package com.example.charles.workingplace.Vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.Modele.Etudiant;
import com.example.charles.workingplace.Modele.Professionel;
import com.example.charles.workingplace.R;

public class InfoLieu extends AppCompatActivity {

    private TextView adresse;
    private TextView capaciter;
    private TextView description;
    private TextView ville;
    private TextView codepostal;
    private Button reserverLieu;
    private TextView messageInfo;

    private Controleur controleur = new Controleur();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_lieu);

        adresse = (TextView) findViewById(R.id.InfoAdresse);
        capaciter = (TextView) findViewById(R.id.InfoCapaciter);
        description= (TextView) findViewById(R.id.InfoDescription);
        codepostal= (TextView) findViewById(R.id.InfoCode);
        ville = (TextView) findViewById(R.id.InfoVille) ;
        reserverLieu =(Button) findViewById(R.id.reserverLieu);
        messageInfo = (TextView) findViewById(R.id.messageInfo);


        adresse.setText(controleur.getLieuSelectionner().getAdresse());
        ville.setText(controleur.getLieuSelectionner().getVille());
        codepostal.setText(Integer.toString(controleur.getLieuSelectionner().getCodepostal()));
        capaciter.setText(Integer.toString(controleur.getLieuSelectionner().getCapacite()));
        description.setText(controleur.getLieuSelectionner().getDescription());


        if(controleur.getUtilisateurCourant() instanceof Professionel)
        {
            reserverLieu.setVisibility(View.INVISIBLE);
            messageInfo.setVisibility(View.INVISIBLE);
        }
        if(controleur.getLieuSelectionner().getStatut()){
            reserverLieu.setEnabled(false);
        }

        reserverLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ouvrirPageReserverLieu();
            }


        });


    }

    public void ouvrirPageReserverLieu(){

        Intent pageInfo = new Intent(InfoLieu.this, ReserverLieu.class);
        startActivity(pageInfo);




    }


}
