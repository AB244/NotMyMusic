package com.cis490.alex.notmymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cis490.alex.notmymusic.Models.SongModel;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Alex on 11/2/2014.
 */
public class MusicAdaptor extends ArrayAdapter<SongModel> {
    private Context songContext;
    private List<SongModel> listSongEntries;
    private SimpleDateFormat df = new SimpleDateFormat("MMM, d, yyyy, (EEE)");

    public MusicAdaptor(Context context, int textViewResourceId, List<SongModel> songEntries) {
        super(context, textViewResourceId, songEntries);
        songContext = context;
        listSongEntries = songEntries;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) songContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.index_item,parent,false);

            final SongModel song = listSongEntries.get(position);

            TextView textViewTitle = (TextView)view.findViewById(R.id.textViewTitle);
            textViewTitle.setText("Title: "+ song.getTitle());

            TextView textViewArtist = (TextView)view.findViewById(R.id.textViewArtist);
            textViewArtist.setText("Artist: "+ song.getArtist());

            TextView textViewAlbum = (TextView)view.findViewById(R.id.textViewAlbum);
            textViewAlbum.setText("Album: "+ song.getAlbum());
        }
        return view;
    }
}
