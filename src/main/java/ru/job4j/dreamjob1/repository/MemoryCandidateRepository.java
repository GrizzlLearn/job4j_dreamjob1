package ru.job4j.dreamjob1.repository;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob1.model.Candidate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dl
 * @date 15.12.2024 20:08
 */

@Repository
@ThreadSafe
public class MemoryCandidateRepository implements CandidateRepository {

    private final AtomicInteger nextId = new AtomicInteger(0);

    private final ConcurrentHashMap<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private MemoryCandidateRepository() {
        save(new Candidate(0, "Иван Петров", "Опытный Java-разработчик", LocalDateTime.now(), 1));
        save(new Candidate(0, "Анна Иванова", "Начинающий аналитик", LocalDateTime.now(), 2));
        save(new Candidate(0, "Сергей Сидоров", "Middle Java Developer", LocalDateTime.now(), 1));
        save(new Candidate(0, "Мария Смирнова", "Frontend-разработчик", LocalDateTime.now(), 3));
        save(new Candidate(0, "Алексей Кузнецов", "DevOps-инженер", LocalDateTime.now(), 2));
    }

    @Override
    public Candidate save(Candidate candidate) {
        candidate.setId(nextId.incrementAndGet());
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
                        candidate.getCreationDate(),
                        candidate.getCityId())) != null;
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
