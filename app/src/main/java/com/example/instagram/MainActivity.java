package com.example.instagram;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.instagram.ui.heart.Heart;
import com.example.instagram.ui.home.HomeFragment;
import com.example.instagram.ui.notifications.NotificationsFragment;
import com.example.instagram.ui.profile.ProfileFragment;
import com.example.instagram.ui.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView cameraToolbar = toolbar.findViewById(R.id.camera);
        cameraToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "camera got clicked", Toast.LENGTH_SHORT).show();
            }
        });

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

                if(menuitem.getItemId()== R.id.navigation_home){
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment,homeFragment);
                    transaction.commit();
                }

                else if(menuitem.getItemId()== R.id.search){
                    SearchFragment searchFragment = new SearchFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment,searchFragment);
                    transaction.commit();
                }

                else if(menuitem.getItemId()== R.id.navigation_notifications){
                    NotificationsFragment notificationsFragment = new NotificationsFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment,notificationsFragment);
                    transaction.commit();
                }

                else if(menuitem.getItemId()== R.id.heart){
                    Heart heartFragment = new Heart();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment,heartFragment);
                    transaction.commit();
                }
                else if(menuitem.getItemId()== R.id.profile){
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment,profileFragment);
                    transaction.commit();
                }
                return true;
            }
        });


    }

}