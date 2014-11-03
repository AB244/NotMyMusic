package com.cis490.alex.notmymusic;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.cis490.alex.notmymusic.Fragments.AddMusicFragment;


public class AddMusicActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_music);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        AddMusicFragment indexFragment = new AddMusicFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_add_layout,indexFragment,"IndexFrag");
        transaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
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
                Toast toast = Toast.makeText(this, "Add Music Currently Displayed.", Toast.LENGTH_LONG);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
