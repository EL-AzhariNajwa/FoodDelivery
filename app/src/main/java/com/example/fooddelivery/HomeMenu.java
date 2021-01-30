package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;


import com.google.android.material.navigation.NavigationView;

public class HomeMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView idmenu;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        idmenu=findViewById(R.id.idmenu);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else{
        super.onBackPressed();}
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_home:
                Intent intent=new Intent(HomeMenu.this,HomePage.class);
                startActivity(intent);
            break;
        }

        return true;
    }
}