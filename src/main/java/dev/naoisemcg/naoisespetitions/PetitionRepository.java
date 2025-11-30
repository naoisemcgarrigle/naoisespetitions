package dev.naoisemcg.naoisespetitions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetitionRepository extends JpaRepository<Petition, Integer> {
    List<Petition> findByTitleContainingIgnoreCase(String term);
}
