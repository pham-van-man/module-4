package org.example.bai_tap_2.controller;

import jakarta.validation.Valid;
import org.example.bai_tap_2.DTO.SongDTO;
import org.example.bai_tap_2.model.Song;
import org.example.bai_tap_2.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @ModelAttribute("song")
    public SongDTO song() {
        return new SongDTO();
    }

    @GetMapping("")
    public String formSong() {
        return "formSong";
    }

    @PostMapping("")
    public String saveSong(@ModelAttribute @Valid SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "formSong";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.saveSong(song);
        redirectAttributes.addFlashAttribute("songDTO", songDTO);
        redirectAttributes.addFlashAttribute("isValid", true);
        return "redirect:/";
    }
}
