package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.LibraryCard;

public interface LibraryCardService {
    LibraryCard saveLibraryCard(LibraryCard libraryCard);

    void deleteLibraryCard(LibraryCard libraryCard);

    LibraryCard getLibraryCardById(Long id);
}
