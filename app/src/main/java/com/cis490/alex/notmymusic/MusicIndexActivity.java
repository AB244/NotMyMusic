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
import android.widget.Toast;

import com.cis490.alex.notmymusic.Fragments.MusicIndexFragment;
import com.cis490.alex.notmymusic.Fragments.MusicSearchFragment;


public class MusicIndexActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_index);

        if(getIntent().getAction().equals("OPEN SEARCH")) {

            CreateGridView();
            activateSearch();
        }
        else if(getIntent().getAction().equals("OPEN SEARCH"))
        {
            CreateGridView();
            AddNewMusic();
        }
        else
        {
            CreateGridView();
        }



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
                FragmentManager manager = getFragmentManager();
                    Fragment frag = manager.findFragmentById(R.id.activity_index_layout);
                if(frag.getClass() == (MusicSearchFragment.class)) {
                    Toast toast = Toast.makeText(this, "Search Currently Displayed.", Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    activateSearch();
                }
                return true;
            case R.id.action_add:
                AddNewMusic();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        }

    public void activateSearch() {
        MusicSearchFragment searchFragment = new MusicSearchFragment();
        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.activity_index_layout, searchFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void AddNewMusic()
    {
        startActivity(new Intent(this, AddMusicActivity.class));
    }

    public void CreateGridView() {
        MusicIndexFragment indexFragment = new MusicIndexFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_index_layout, indexFragment, "IndexFrag");
        transaction.commit();
    }
}
