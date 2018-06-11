package com.example.charles.workingplace.Vue;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.Modele.Utilisateur;
import com.example.charles.workingplace.R;


public class MainActivity extends AppCompatActivity {

     private Button enregistrer;
     private Button connecter;
     private EditText email;
     private EditText mdp;

     private Controleur controleur = new Controleur();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);



        email = (EditText) findViewById(R.id.loginEmail);
        //email = sc.nextLine();

        mdp = (EditText) findViewById(R.id.loginMdp);
        enregistrer = (Button) findViewById(R.id.enregistrer);
        connecter = (Button) findViewById(R.id.connecter);






        connecter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                boolean connexion = false;

                for(  Utilisateur i  : controleur.getListeUtilisateur()){
                    if(email.getText().toString().equals(i.getEmail()) && mdp.getText().toString().equals(i.getMdp())){
                        controleur.setUtilisateurCourant(i);
                        connexion = true;
                       // NotificationCompat.Builder mBuilder =
                              //  new NotificationCompat.Builder(MainActivity.this)
                                   //     .setSmallIcon(R.drawable.notification)
                                    //    .setContentTitle(getResources().getString(R.string.notification_title))
                                      //  .setContentText(getResources().getString(R.string.notification_desc))
                                       // .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
                        // .setSound(R.raw.alarm);

                       // NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                       // mNotificationManager.notify(001, mBuilder.build());

                        ouvrirPageHome();
                        break;
                    }
            }
            if(!connexion){
                creerUnToast("Login ou mot de passe incorrect !");
            }

        }});

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirPageEnregistrer();
            }
        });

    }


    public void ouvrirPageEnregistrer(){

        Intent pageEnregistrer = new Intent(MainActivity.this, Enregistrer.class);
        startActivity(pageEnregistrer);




    }

    public void ouvrirPageHome(){

        Intent pageHome = new Intent(MainActivity.this, Home.class);
        startActivity(pageHome);




    }
    public void creerUnToast(CharSequence erreur){

        Context appContext = getApplicationContext();
        int duree = Toast.LENGTH_SHORT;

        Toast messageErreur = Toast.makeText(appContext, erreur, duree);
        messageErreur.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
