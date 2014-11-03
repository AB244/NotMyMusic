package com.cis490.alex.notmymusic.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.cis490.alex.notmymusic.Models.SongModel;
import com.cis490.alex.notmymusic.MusicAdaptor;
import com.cis490.alex.notmymusic.MusicDetailActivity;
import com.cis490.alex.notmymusic.R;
import com.cis490.alex.notmymusic.Service.FakeMusicSercice;

import java.util.List;


public class MusicIndexFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_music_index,container,false);

    }

    public void onStart() {
        super.onStart();

        GridView indexGridView = (GridView) getActivity().findViewById(R.id.gridMusicIndexView);
        List<SongModel> songs = new FakeMusicSercice().findAll();

        MusicAdaptor songAdaptor = new MusicAdaptor(getActivity(), R.layout.activity_music_index, songs);
        indexGridView.setAdapter(songAdaptor);


        /*On Click event for Single Grid view Item*/
        indexGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getActivity(), MusicDetailActivity.class);
                startActivity(i);
            }
        });
    }
}
