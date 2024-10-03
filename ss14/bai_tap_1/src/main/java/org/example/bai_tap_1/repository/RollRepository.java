package org.example.bai_tap_1.repository;

import org.example.bai_tap_1.model.Role;
import org.example.bai_tap_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RollRepository extends JpaRepository<Role, Integer> {
    List<Role> findByUser(User user);
}
