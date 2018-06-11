package com.example.charles.workingplace.Vue;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.charles.workingplace.Controleur.Controleur;
import com.example.charles.workingplace.Modele.Lieu;
import com.example.charles.workingplace.Modele.Professionel;
import com.example.charles.workingplace.Modele.Utilisateur;
import com.example.charles.workingplace.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private GoogleMap mMap;

    private Controleur controleur = new Controleur();

    private Geocoder geocoder;

    private HashMap<Marker, Lieu> hashMap = new HashMap<Marker, Lieu>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings mapUiSettings = mMap.getUiSettings();
        mapUiSettings.setZoomControlsEnabled(true);



        geocoder = new Geocoder(MapsActivity.this);





        for(Utilisateur y: controleur.getListeUtilisateur()){

            if(y instanceof Professionel){

                for(Lieu i :y.getListeLieux()){


                    try{
                        if(i.getStatut()){
                            List<Address> adresse = geocoder.getFromLocationName(i.getAdresse() + i.getVille() + i.getCodepostal(), 1);
                            LatLng lieu = new LatLng(adresse.get(0).getLatitude(),adresse.get(0).getLongitude());
                            Marker marker = mMap.addMarker(new MarkerOptions().position(lieu).title( i.getAdresse()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                            mMap.setOnMarkerClickListener(this);
                            hashMap.put(marker, i);

                        }
                        else{
                            List<Address> adresse = geocoder.getFromLocationName(i.getAdresse() + i.getVille() + i.getCodepostal(), 1);
                            LatLng lieu = new LatLng(adresse.get(0).getLatitude(),adresse.get(0).getLongitude());
                            Marker marker = mMap.addMarker(new MarkerOptions().position(lieu).title( i.getAdresse()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                            mMap.setOnMarkerClickListener(this);
                            hashMap.put(marker, i);

                        }

                    }
                    catch (IOException e){
                        creerUnToast("Adresse introuvable : " + i.getAdresse() );
                    }




                }
            }



        }

        // Add a marker in Sydney and move the camera t
        LatLng paris = new LatLng(48.866667, 2.333333);
        //mMap.addMarker(new MarkerOptions().position(paris).title("Marker in Paris"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(paris));
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {

        Iterator it = hashMap.entrySet().iterator();

        while(it.hasNext())
        {
            HashMap.Entry item = (HashMap.Entry)it.next();
            if(marker.equals(item.getKey()))
            {
                controleur.setLieuSelectionner((Lieu)item.getValue());
                creerUnToast(controleur.getLieuSelectionner().getAdresse());
                ouvrirPageInfoLieu();
            }
            else{
                creerUnToast("Erreur");
            }


        }

        return false;
    }

    public void creerUnToast(CharSequence erreur){

        Context appContext = getApplicationContext();
        int duree = Toast.LENGTH_SHORT;

        Toast messageErreur = Toast.makeText(appContext, erreur, duree);
        messageErreur.show();

    }

    public void ouvrirPageInfoLieu(){

        Intent pageInfo = new Intent(MapsActivity.this, InfoLieu.class);
        startActivity(pageInfo);




    }




}
