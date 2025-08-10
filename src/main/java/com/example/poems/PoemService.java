package com.example.poems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoemService {

    @Autowired
    private PoemRepository poemRepository;

    public List<Poem> getAllPoems() {
        return poemRepository.findAll();
    }

    public Poem createPoem(Poem poem) {
        return poemRepository.save(poem);
    }

    public Optional<Poem> updatePoem(Long id, Poem updatedPoem) {
        return poemRepository.findById(id).map(poem -> {
            poem.setTitle(updatedPoem.getTitle());
            poem.setContent(updatedPoem.getContent());
            return poemRepository.save(poem);
        });
    }

    public void deletePoem(Long id) {
        poemRepository.deleteById(id);
    }
}

