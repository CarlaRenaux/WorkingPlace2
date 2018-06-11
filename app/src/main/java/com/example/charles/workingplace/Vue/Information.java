package com.example.charles.workingplace.Vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.Modele.Etudiant;
import com.example.charles.workingplace.R;

public class Information extends AppCompatActivity {

    private Controleur controleur = new Controleur();

    private TextView infoPrenom;
    private TextView infoNom;
    private TextView infoAge;
    private TextView infoEmail;
    private TextView infoLieu;
    private Button modifierMdp;
    private TextView infoLieuReserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        infoPrenom = (TextView) findViewById(R.id.infoPrenom);
        infoNom= (TextView) findViewById(R.id.infoNom);
        infoAge = (TextView) findViewById(R.id.infoAge);
        infoEmail = (TextView) findViewById(R.id.infoEmail);
        infoLieu = (TextView) findViewById(R.id.infoLieu);
        modifierMdp = (Button) findViewById(R.id.modifierMdp);
        infoLieuReserve = (TextView) findViewById(R.id.InfoLieuReserver);


        infoPrenom.setText(controleur.getUtilisateurCourant().recupererPrenom());
        infoNom.setText(controleur.getUtilisateurCourant().recupererNom());
        infoAge.setText(Integer.toString(controleur.getUtilisateurCourant().recupererAge()));
        infoEmail.setText(controleur.getUtilisateurCourant().getEmail());
        if(controleur.getUtilisateurCourant() instanceof Etudiant){
            infoLieuReserve.setText("Vos lieux réservés");
        }

        else{
            infoLieuReserve.setText("Lieux ajouté(s)");
        }

        if(controleur.getUtilisateurCourant().getListeLieux().size() == 1){


            infoLieu.setText("• " +
                    controleur.getUtilisateurCourant().getListeLieux().get(0).getAdresse() + " \n" + "Le "
                    + controleur.getUtilisateurCourant().getListeLieux().get(0).getDate() + " De " +
                    controleur.getUtilisateurCourant().getListeLieux().get(0).getHeure() +
                    " à " + controleur.getUtilisateurCourant().getListeLieux().get(0).getHeureFin()

            );


            }

        else if(controleur.getUtilisateurCourant().getListeLieux().size() == 2 ){


            infoLieu.setText("• " +
                    controleur.getUtilisateurCourant().getListeLieux().get(0).getAdresse()+
                      "Le "
                            + controleur.getUtilisateurCourant().getListeLieux().get(0).getDate() + " De " +
                            controleur.getUtilisateurCourant().getListeLieux().get(0).getHeure() +
                            " à " + controleur.getUtilisateurCourant().getListeLieux().get(0).getHeureFin() + " \n" +
                    controleur.getUtilisateurCourant().getListeLieux().get(1).getAdresse() +
                    " \n" + "Le "
                    + controleur.getUtilisateurCourant().getListeLieux().get(1).getDate() + " De " +
                    controleur.getUtilisateurCourant().getListeLieux().get(1).getHeure() +
                    " à " + controleur.getUtilisateurCourant().getListeLieux().get(1).getHeureFin()

            );


        }
        else if(controleur.getUtilisateurCourant().getListeLieux().size() >= 3 ){


            infoLieu.setText("• " +
                    controleur.getUtilisateurCourant().getListeLieux().get(0).getAdresse()+ "Le "
                            + controleur.getUtilisateurCourant().getListeLieux().get(0).getDate() + " De " +
                            controleur.getUtilisateurCourant().getListeLieux().get(0).getHeure() +
                            " à " + controleur.getUtilisateurCourant().getListeLieux().get(0).getHeureFin() + "\n" +
                    controleur.getUtilisateurCourant().getListeLieux().get(1).getAdresse()+
                    "\n• " + "Le "
                            + controleur.getUtilisateurCourant().getListeLieux().get(1).getDate() + " De " +
                            controleur.getUtilisateurCourant().getListeLieux().get(1).getHeure() +
                            " à " + controleur.getUtilisateurCourant().getListeLieux().get(1).getHeureFin() + " \n" +
                    controleur.getUtilisateurCourant().getListeLieux().get(2).getAdresse()  + "Le "
                    + controleur.getUtilisateurCourant().getListeLieux().get(2).getDate() + " De " +
                    controleur.getUtilisateurCourant().getListeLieux().get(2).getHeure() +
                    " à " + controleur.getUtilisateurCourant().getListeLieux().get(2).getHeureFin()

            );


        }

        else{

            infoLieu.setText("Aucun lieu disponible.");




        }



        modifierMdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ouvrirModifierMdp();



            }
        });







    }

    public void ouvrirModifierMdp(){

        Intent page = new Intent(Information.this, ModifierMdp.class);
        startActivity(page);




    }
}
