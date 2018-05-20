package com.example.trungspc.werewolf.activities;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.trungspc.werewolf.fragments.AchievementFragment;
import com.example.trungspc.werewolf.fragments.FriendsFragment;
import com.example.trungspc.werewolf.fragments.LobbyFragment;
import com.example.trungspc.werewolf.fragments.ProfileFragment;
import com.example.trungspc.werewolf.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        toolbar.setTitle("Friends");
        loadFragment(new FriendsFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_friends:
                toolbar.setTitle("Friends");
                fragment = new FriendsFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_lobby:
                toolbar.setTitle("Game Lobby");
                fragment = new LobbyFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_achievements:
                toolbar.setTitle("Achievements");
                fragment = new AchievementFragment();
                loadFragment(fragment);
                return true;
            case R.id.navigation_profile:
                toolbar.setTitle("Profile");
                fragment = new ProfileFragment();
                loadFragment(fragment);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_buttons, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        String[] exitMessages = getResources().getStringArray(R.array.exit_message);
        int messageIndex = new Random().nextInt(exitMessages.length);
        new AlertDialog.Builder(this)
                .setTitle("Leaving so soon?")
                .setMessage(exitMessages[messageIndex])
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
