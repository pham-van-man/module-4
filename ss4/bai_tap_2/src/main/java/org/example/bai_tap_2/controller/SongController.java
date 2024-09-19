package org.example.bai_tap_2.controller;

import org.example.bai_tap_2.model.Song;
import org.example.bai_tap_2.model.SongForm;
import org.example.bai_tap_2.service.ServiceSong;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;
    private ServiceSong serviceSong;

    public SongController(ServiceSong serviceSong) {
        this.serviceSong = serviceSong;
    }

    @ModelAttribute("song")
    public Song getSong() {
        return new Song();
    }
    @ModelAttribute("songForm")
    public SongForm getSongForm() {
        return new SongForm();
    }

    @GetMapping("/")
    public String songList(Model model) {
        List<Song> songs = serviceSong.findAll();
        model.addAttribute("songs", songs);
        return "songList";
    }

    @GetMapping("/create")
    public String showUploadForm() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String uploadSong(@ModelAttribute SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getFilePath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getName(), songForm.getArtist(),
                songForm.getGenre(), fileName);
        serviceSong.save(song);
        redirectAttributes.addFlashAttribute("message", "Song uploaded successfully.");
        return "redirect:/";
    }
}

