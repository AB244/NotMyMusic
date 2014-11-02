package com.cis490.alex.notmymusic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MusicIndexActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_index);

        MusicIndexFragment indexFragment = new MusicIndexFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_index_layout, indexFragment, "IndexFrag");
        transaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.music_index_menu_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                MusicSearchFragment searchFragment = new MusicSearchFragment();
                FragmentManager manager = getFragmentManager();

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.activity_index_layout, searchFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                return true;
            case R.id.action_add:
                startActivity(new Intent(this, AddMusicActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
