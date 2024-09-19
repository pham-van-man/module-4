package org.example.bai_tap_2.service;

import org.example.bai_tap_2.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceSongImpl implements ServiceSong {
    private final List<Song> songs;

    public ServiceSongImpl() {
        songs = new ArrayList<>();
    }

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        songs.add(song);
    }
}
