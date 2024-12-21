package ru.job4j.dreamjob1.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob1.model.Candidate;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author dl
 * @date 15.12.2024 20:08
 */

@Repository
public class MemoryCandidateRepository implements CandidateRepository {
    private static final MemoryCandidateRepository INSTANCE = new MemoryCandidateRepository();

    private int nextId = 1;

    private final Map<Integer, Candidate> candidates = new HashMap<>();

    private MemoryCandidateRepository() {
        save(new Candidate(0, "Иван Петров", "Опытный Java-разработчик", LocalDateTime.now()));
        save(new Candidate(0, "Анна Иванова", "Начинающий аналитик", LocalDateTime.now()));
        save(new Candidate(0, "Сергей Сидоров", "Middle Java Developer", LocalDateTime.now()));
        save(new Candidate(0, "Мария Смирнова", "Frontend-разработчик", LocalDateTime.now()));
        save(new Candidate(0, "Алексей Кузнецов", "DevOps-инженер", LocalDateTime.now()));
    }

    public static MemoryCandidateRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public Candidate save(Candidate candidate) {
        candidate.setId(nextId++);
        candidates.put(candidate.getId(), candidate);
        return candidate;
    }

    @Override
    public Optional<Candidate> deleteById(int id) {
        return Optional.ofNullable(candidates.remove(id));
    }

    @Override
    public boolean update(Candidate candidate) {
        return candidates.computeIfPresent(candidate.getId(),
                (id, oldCandidate) -> new Candidate(oldCandidate.getId(),
                        candidate.getName(),
                        candidate.getDescription(),
                        candidate.getCreationDate())) != null;
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return Optional.ofNullable(candidates.get(id));
    }

    @Override
    public Collection<Candidate> findAll() {
        return candidates.values();
    }
}
