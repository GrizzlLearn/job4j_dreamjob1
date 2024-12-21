package ru.job4j.dreamjob1.service;

import ru.job4j.dreamjob1.model.Candidate;
import java.util.Collection;
import java.util.Optional;

/**
 * @author dl
 * @date 21.12.2024 20:22
 */
public interface CandidateService {
    Candidate save(Candidate candidate);

    Optional<Candidate> deleteById(int id);

    boolean update(Candidate candidate);

    Optional<Candidate> findById(int id);

    Collection<Candidate> findAll();
}
