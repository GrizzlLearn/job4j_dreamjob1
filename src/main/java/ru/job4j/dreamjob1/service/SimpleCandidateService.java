package ru.job4j.dreamjob1.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob1.model.Candidate;
import ru.job4j.dreamjob1.repository.CandidateRepository;
import java.util.Collection;
import java.util.Optional;

/**
 * @author dl
 * @date 21.12.2024 20:23
 */

@Service
@ThreadSafe
public class SimpleCandidateService implements CandidateService {
    private final CandidateRepository candidateRepository;

    private SimpleCandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Optional<Candidate> deleteById(int id) {
        return candidateRepository.deleteById(id);
    }

    @Override
    public boolean update(Candidate candidate) {
        return candidateRepository.update(candidate);
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Collection<Candidate> findAll() {
        return candidateRepository.findAll();
    }
}
