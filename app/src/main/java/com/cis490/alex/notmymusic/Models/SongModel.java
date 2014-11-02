package com.cis490.alex.notmymusic.Models;

/**
 * Created by Alex on 11/2/2014.
 */
public class SongModel {

    //Attributes
    private int ID;
    private String Title;
    private String Artist;
    private String Album;


    public SongModel() {}

    public SongModel(String title, String artist, String album ) {
        this.Title = title;
        this.Artist = artist;
        this.Album = album;
    }

    public String getTitle() {
        return Title;
    }

    public String getArtist() {
        return Artist;
    }

    public String getAlbum() {
        return Album;
    }
}
