package org.example.bai_tap_2.service;

import org.example.bai_tap_2.model.Song;
import org.example.bai_tap_2.repository.SongRepository;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }
}
