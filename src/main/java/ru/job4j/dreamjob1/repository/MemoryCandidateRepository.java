package ru.job4j.dreamjob1.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob1.model.Candidate;

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
        save(new Candidate(0, "Иван Петров", "Опытный Java-разработчик", "2024-12-15"));
        save(new Candidate(0, "Анна Иванова", "Начинающий аналитик", "2024-11-30"));
        save(new Candidate(0, "Сергей Сидоров", "Middle Java Developer", "2024-10-05"));
        save(new Candidate(0, "Мария Смирнова", "Frontend-разработчик", "2024-09-20"));
        save(new Candidate(0, "Алексей Кузнецов", "DevOps-инженер", "2024-08-01"));
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
    public void deleteById(int id) {
        candidates.remove(id);
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
