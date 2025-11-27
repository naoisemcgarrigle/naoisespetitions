package dev.naoisemcg.naoisespetitions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetitionService {
    private final PetitionRepository petitionRepository;

    public PetitionService(PetitionRepository petitionRepository) {
        this.petitionRepository = petitionRepository;
    }

    public List<Petition> getAllPetitions() {
        return petitionRepository.findAll();
    }

    public void createNewPetition(Petition petition) {
        petitionRepository.save(petition);
    }

    public Petition getPetitionById(Integer id) {
        return petitionRepository.findById(id).orElseThrow(() -> new RuntimeException("Petition not found!"));
    }

    public void signPetition(Integer petitionId, String signature) {
        Petition petition = getPetitionById(petitionId);
        petition.getSignatures().add(signature);
        petitionRepository.save(petition);
    }

    public List<Petition> searchPetitions(String term) {
        return petitionRepository.findByTitleContaining(term);
    }
}
