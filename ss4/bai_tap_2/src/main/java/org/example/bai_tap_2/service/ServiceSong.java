package org.example.bai_tap_2.service;

import org.example.bai_tap_2.model.Song;

import java.util.List;

public interface ServiceSong {
    List<Song> findAll();
    void save(Song song);
}
