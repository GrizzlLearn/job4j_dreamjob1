package ru.job4j.dreamjob1.service;

import ru.job4j.dreamjob1.model.Vacancy;
import ru.job4j.dreamjob1.repository.MemoryVacancyRepository;
import ru.job4j.dreamjob1.repository.VacancyRepository;

import java.util.Collection;
import java.util.Optional;

/**
 * @author dl
 * @date 21.12.2024 19:47
 */
public class SimpleVacancyService implements VacancyService {

    private static final SimpleVacancyService INSTANCE = new SimpleVacancyService();
    private final VacancyRepository vacancyRepository = MemoryVacancyRepository.getInstance();
    private SimpleVacancyService() {

    }

    public static SimpleVacancyService getInstance() {
        return INSTANCE;
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Optional<Vacancy> deleteById(int id) {
        return vacancyRepository.deleteById(id);
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return vacancyRepository.update(vacancy);
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return vacancyRepository.findById(id);
    }

    @Override
    public Collection<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }
}
