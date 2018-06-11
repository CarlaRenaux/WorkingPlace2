package com.example.charles.workingplace.Vue;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.R;


public class Enregistrer extends AppCompatActivity {


    private EditText nom;
    private EditText prenom;
    private EditText age;
    private EditText email;
    private EditText mdp;
    private EditText mdpConfirmer;
    private Button enregistrer;
    private CheckBox etudiant;
    private CheckBox professionnel;

    private boolean etd, prof;



    private Controleur controleur = new Controleur();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrer);

        enregistrer = (Button) findViewById(R.id.enregistrer);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        mdp = (EditText) findViewById(R.id.mdp);
        mdpConfirmer = (EditText) findViewById(R.id.mdpConfirmer);
        etudiant = (CheckBox) findViewById(R.id.etudiant);
        professionnel = (CheckBox) findViewById(R.id.professionnel);

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(enregistrer())
                {
                    if(etudiant.isChecked() && !professionnel.isChecked())
                    {
                        controleur.creerEtudiant(nom.getText().toString(),
                                prenom.getText().toString(),
                                Integer.parseInt(age.getText().toString()),
                                email.getText().toString(),
                                mdp.getText().toString()
                        );
                        creerUnToast("Votre profil a été créé avec succes.");



                        ouvrirPageLogin();


                    }
                    else if(professionnel.isChecked() && !etudiant.isChecked()) {

                        controleur.creerProfessionnel(nom.getText().toString(),
                                prenom.getText().toString(),
                                Integer.parseInt(age.getText().toString()),
                                email.getText().toString(),
                                mdp.getText().toString()
                        );
                        creerUnToast("Votre profil a été créé avec succes.");

                        ouvrirPageLogin();

                    }



                    else{

                        creerUnToast("Champs incomplet ou mot de passe incorrect.");

                    }



                }

                else{

                    creerUnToast("Champs incomplet ou mot de passe incorrect.");
                }


            }
        });
    }

    public boolean enregistrer(){




        if(!nom.getText().toString().equals("") &&
                !prenom.getText().toString().equals("") &&
                !age.getText().toString().equals("") &&
                !email.getText().toString().equals("") &&
                !mdp.getText().toString().equals("") &&
                !mdpConfirmer.getText().toString().equals("") &&

                controleur.verifierMdp(mdp.getText().toString(), mdpConfirmer.getText().toString())

                ){


            return true;


        }
        else{

            return false;
        }

    }


    public void ouvrirPageLogin(){

        Intent pageLogin = new Intent(Enregistrer.this, MainActivity.class);
        startActivity(pageLogin);

    }

    public void creerUnToast(CharSequence erreur){

        Context appContext = getApplicationContext();
        int duree = Toast.LENGTH_SHORT;

        Toast messageErreur = Toast.makeText(appContext, erreur, duree);
        messageErreur.show();

    }






}
