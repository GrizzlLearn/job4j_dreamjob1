package ru.job4j.dreamjob1.service;

import ru.job4j.dreamjob1.dto.FileDto;
import ru.job4j.dreamjob1.model.Vacancy;
import java.util.Collection;
import java.util.Optional;

/**
 * @author dl
 * @date 21.12.2024 19:46
 */

public interface VacancyService {
    Vacancy save(Vacancy vacancy, FileDto image);

    Optional<Vacancy> deleteById(int id);

    boolean update(Vacancy vacancy, FileDto image);

    Optional<Vacancy> findById(int id);

    Collection<Vacancy> findAll();
}
