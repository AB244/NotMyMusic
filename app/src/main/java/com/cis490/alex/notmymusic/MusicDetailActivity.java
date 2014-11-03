package com.cis490.alex.notmymusic;

import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.cis490.alex.notmymusic.Fragments.DetailTabFragments.MusicDetailFragment;
import com.cis490.alex.notmymusic.Fragments.MusicSearchFragment;


public class MusicDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionbar.newTab().setText("Details");
        tab1.setTabListener(new MyTabListener());
        actionbar.addTab(tab1);

        ActionBar.Tab tab2 = actionbar.newTab().setText("More Music");
        tab2.setTabListener(new MyTabListener());
        actionbar.addTab(tab2);

        ActionBar.Tab tab3 = actionbar.newTab().setText("Events");
        tab3.setTabListener(new MyTabListener());
        actionbar.addTab(tab3);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.music_detail_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:

                Intent intent = new Intent(this, MusicIndexActivity.class);
                intent.setAction("OPEN SEARCH");

                startActivity(intent);
                return true;
            case R.id.action_add:
                startActivity(new Intent(this, AddMusicActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
