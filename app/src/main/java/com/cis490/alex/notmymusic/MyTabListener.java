package com.cis490.alex.notmymusic;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.cis490.alex.notmymusic.Fragments.DetailTabFragments.More_Music_Detail_Fragment;
import com.cis490.alex.notmymusic.Fragments.DetailTabFragments.MusicDetailFragment;
import com.cis490.alex.notmymusic.Fragments.DetailTabFragments.Music_Events_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 11/2/2014.
 */
public class MyTabListener implements ActionBar.TabListener {
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        List<Fragment> fragList = new ArrayList<Fragment>();
        Fragment frag = null;

        if(tab.getPosition()==0){

            MusicDetailFragment detailFragment = new MusicDetailFragment();
            ft.replace(R.id.activity_detail_layout,detailFragment,"Details");
        }

        else if(tab.getPosition()==1){

            More_Music_Detail_Fragment more_music_detail_fragment = new More_Music_Detail_Fragment();
            ft.replace(R.id.activity_detail_layout,more_music_detail_fragment,"More Music");
        }
        else{

            Music_Events_Fragment music_events_fragment = new Music_Events_Fragment();
            ft.replace(R.id.activity_detail_layout,music_events_fragment,"Music Events");
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
