package com.yasination.drawernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
   // FrameLayout frameLayout;
    NavigationView navigationView;




    View headerView;   //-find drawer Header Item---open--------
    TextView headerTitle;
    TextView headerDescription;

    ImageView headerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        materialToolbar = findViewById(R.id.materialToolbar);
      //  frameLayout = findViewById(R.id.frameLayout);
        navigationView = findViewById(R.id.navigationView);

        //----------find drawer Header Item----------open--------
        headerView = navigationView.getHeaderView(0);
        headerImage = headerView.findViewById(R.id.headerImage);
        headerTitle = headerView.findViewById(R.id.headerTitle);
        headerDescription = headerView.findViewById(R.id.headerDescription);

        headerTitle.setText("Beauti Akter");

        //---------------------Fragment in first Page-----------------------open----

        FirstFragment.WEB_URL = "https://google.com/";
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, new FirstFragment());
        fragmentTransaction.commit();

        //---------------------bridge making or connection with drawer-----------------------open----
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,drawerLayout,materialToolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        //---------------------working with drawer Footer navigation item-----------------------open----
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.google){

                    FirstFragment.WEB_URL = "https://google.com/";
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new FirstFragment());
                    fragmentTransaction.commit();

                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);


                }else if (item.getItemId()==R.id.facebook){

                    headerTitle.setText("Yasin Arafat");
                    FirstFragment.WEB_URL = "https://facebook.com/";
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new FirstFragment());
                    fragmentTransaction.commit();
                    Toast.makeText(MainActivity.this, "profile", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);


                }else if (item.getItemId()==R.id.notification){
                    Toast.makeText(MainActivity.this, "notification", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (item.getItemId()==R.id.setting){
                    Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });

        //---------------------working with toolbar item-----------------------open----

        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.share){
                    Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();
                 }else if (item.getItemId()==R.id.save){
                    Toast.makeText(MainActivity.this, "save", Toast.LENGTH_SHORT).show();
                 } else if (item.getItemId()==R.id.like){
                    Toast.makeText(MainActivity.this, "like", Toast.LENGTH_SHORT).show();
                 }

                return false;
            }
        });





    }
    //-------------------------------------------------------
}