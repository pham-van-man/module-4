package org.example.bai_tap_1.service;

import org.example.bai_tap_1.model.LibraryCard;
import org.example.bai_tap_1.repository.LibraryCardRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryCardServiceImpl implements LibraryCardService {
    private final LibraryCardRepository libraryCardRepository;

    public LibraryCardServiceImpl(LibraryCardRepository libraryCardRepository) {
        this.libraryCardRepository = libraryCardRepository;
    }

    @Override
    public LibraryCard saveLibraryCard(LibraryCard libraryCard) {
        return libraryCardRepository.save(libraryCard);
    }

    @Override
    public void deleteLibraryCard(LibraryCard libraryCard) {
        libraryCardRepository.delete(libraryCard);
    }

    @Override
    public LibraryCard getLibraryCardById(Long id) {
        LibraryCard libraryCard = libraryCardRepository.findById(id).orElse(null);
        if (libraryCard == null) {
            throw new UnsupportedOperationException();
        }
        return libraryCard;
    }
}
