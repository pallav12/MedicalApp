package com.alonemusk.medicalapp;

import android.net.Uri;
import android.os.Bundle;

import com.alonemusk.medicalapp.ui.Cart.Cart;
import com.alonemusk.medicalapp.ui.EnterAdress.ItemFragment;
import com.alonemusk.medicalapp.ui.EnterAdress.dummy.DummyContent;
import com.alonemusk.medicalapp.ui.Medicine_Result.AfterSearch;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class FirstActivity extends AppCompatActivity implements
        ItemFragment.OnListFragmentInteractionListener, AfterSearch.OnFragmentInteractionListener, Cart.OnFragmentInteractionListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getSupportActionBar().hide();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_Reminder,R.id.navigation_Article, R.id.navigation_notifications,R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
