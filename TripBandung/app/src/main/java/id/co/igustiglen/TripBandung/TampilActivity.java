package id.co.igustiglen.TripBandung;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by I Gusti Glen on 11-Agustus-20.
 * Nim :10117099
 * Kelas :IF-3
 */

public class TampilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Home_Fragment home_fragment;
    private TampilFragment wisata_fragment;

    private TampilFragment baksil, alunalun, bcc, tebingkeraton, saungangklung, gedungmerdeka, goa, jendelaalam,
            kampungbatu, kebunbinatang,kebunstrawberry;


    private Button bDirection;
    private LatLng dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Fragment
        wisata_fragment = new TampilFragment(R.layout.fragment_wisata);


        //Wisata
        baksil = new TampilFragment(R.layout.baksil);
        alunalun = new TampilFragment(R.layout.alunalun);
        bcc = new TampilFragment(R.layout.bcc);
        tebingkeraton = new TampilFragment(R.layout.tebingkeraton);
        saungangklung = new TampilFragment(R.layout.saungangklung);
        gedungmerdeka = new TampilFragment(R.layout.gedungmerdeka);
        goa = new TampilFragment(R.layout.goa);
        jendelaalam = new TampilFragment(R.layout.jendelaalam);
        kampungbatu = new TampilFragment(R.layout.kampungbatu);
        kebunbinatang = new TampilFragment(R.layout.kebunbinatang);
        kebunstrawberry = new TampilFragment(R.layout.kebunstrawberry);





        home_fragment = new Home_Fragment(this);
        pushFragment(home_fragment);

        bDirection = findViewById(R.id.direction);
        bDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dir != null){
                    Intent i = new Intent("android.intent.action.MAPS");
                    i.putExtra("Lat", dir.latitude);
                    i.putExtra("Lon", dir.longitude);
                    startActivity(i);
                }else{
                    Toast.makeText(TampilActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        bDirection.setVisibility(View.GONE);

        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_home:
                pushFragment(home_fragment);
                break;
            case R.id.nav_wisata:
                pushFragment(wisata_fragment);
                break;

            //Tentang
            case R.id.nav_tentang_aplikasi:
                final Dialog dialog = new Dialog(this, R.style.dialog_notitle);
                dialog.setContentView(R.layout.tentang_aplikasi);
                dialog.show();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //Wisata Fragment
    public void wisata(View v) {
        switch (v.getId()) {
            case R.id.wisata1:

                pushFragment( baksil);
                dir = new LatLng(-6.885157, 107.610294);
                break;
            case R.id.wisata2:
                pushFragment(alunalun);
                dir = new LatLng(-6.921886, 107.606941);
                break;
            case R.id.wisata3:
                pushFragment(bcc);
                dir = new LatLng(-6.877468, 107.594705);
                break;
            case R.id.wisata4:
                pushFragment(tebingkeraton);
                dir = new LatLng(-6.834110, 107.663625);
                break;
            case R.id.wisata5:
                pushFragment(saungangklung);
                dir = new LatLng(-6.898058, 107.654973);
                break;
            case R.id.wisata6:
                pushFragment(gedungmerdeka);
                dir = new LatLng(-6.921124, 107.609592);
                break;
            case R.id.wisata7:
                pushFragment(goa);
                dir = new LatLng(-6.854477, 107.637792);
                break;
            case R.id.wisata8:
                pushFragment(jendelaalam);
                dir = new LatLng(-6.819622, 107.596453);
                break;
            case R.id.wisata9:
                pushFragment(kampungbatu);
                dir = new LatLng(-7.009370, 107.606960);
                break;
            case R.id.wisata10:
                pushFragment(kebunbinatang);
                dir = new LatLng(-6.890298, 107.606820);
                break;
            case R.id.wisata11:
                pushFragment(kebunstrawberry);
                dir = new LatLng(-7.139868, 107.397260);
                break;

        }
        bDirection.setVisibility(View.VISIBLE);
    }




    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.rootLayout, fragment);
                ft.commit();
            }
        }
    }
}
