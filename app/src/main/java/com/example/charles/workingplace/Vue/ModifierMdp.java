package com.example.charles.workingplace.Vue;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.R;

public class ModifierMdp extends AppCompatActivity {

    private Controleur controleur = new Controleur();

    private EditText ancienMdp;
    private EditText nouveauMdp;
    private EditText confirmerMdp;
    private Button buttonConfirmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_mdp);

        ancienMdp = (EditText) findViewById(R.id.ancienMdp);
        nouveauMdp =(EditText) findViewById(R.id.nouveauMdp);
        confirmerMdp =(EditText) findViewById(R.id.nouveauMdp2);
        buttonConfirmer = (Button) findViewById(R.id.buttonConfirmer);

        buttonConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(controleur.verifierMdp(ancienMdp.getText().toString(), controleur.getUtilisateurCourant().getMdp())
                        && controleur.verifierMdp(nouveauMdp.getText().toString(), confirmerMdp.getText().toString())
                        ){

                    controleur.getUtilisateurCourant().setMdp(nouveauMdp.getText().toString());
                    creerUnToast("Mot de passe modifié !");
                    ouvrir();
                }

                else{
                    creerUnToast("Mot de passe incorrect.");
                }
            }
        });




    }

    public void creerUnToast(CharSequence erreur){

        Context appContext = getApplicationContext();
        int duree = Toast.LENGTH_SHORT;

        Toast messageErreur = Toast.makeText(appContext, erreur, duree);
        messageErreur.show();

    }

    public void ouvrir(){

        Intent page = new Intent(ModifierMdp.this, MainActivity.class);
        startActivity(page);




    }






}
