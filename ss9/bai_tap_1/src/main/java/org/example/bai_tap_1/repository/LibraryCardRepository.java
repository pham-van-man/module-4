package org.example.bai_tap_1.repository;

import org.example.bai_tap_1.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Long> {
}
