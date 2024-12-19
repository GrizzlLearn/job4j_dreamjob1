package ru.job4j.dreamjob1.repository;

import ru.job4j.dreamjob1.model.Candidate;

import java.util.Collection;
import java.util.Optional;

/**
 * @author dl
 * @date 15.12.2024 20:02
 */
public interface CandidateRepository {
    Candidate save(Candidate candidate);

    Optional<Candidate> deleteById(int id);

    boolean update(Candidate candidate);

    Optional<Candidate> findById(int id);

    Collection<Candidate> findAll();
}
