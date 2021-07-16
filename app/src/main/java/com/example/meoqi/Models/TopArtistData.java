package com.example.meoqi.Models;

public class TopArtistData {

    String artist_name;
    String artist_image_url;

    public TopArtistData(String artist_name, String artist_image_url) {
        this.artist_name = artist_name;
        this.artist_image_url = artist_image_url;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getArtist_image_url() {
        return artist_image_url;
    }

    public void setArtist_image_url(String artist_image_url) {
        this.artist_image_url = artist_image_url;
    }
}
