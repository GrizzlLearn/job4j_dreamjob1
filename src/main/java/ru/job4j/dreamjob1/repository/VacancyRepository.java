package ru.job4j.dreamjob1.repository;

import ru.job4j.dreamjob1.model.Vacancy;
import java.util.Collection;
import java.util.Optional;

/**
 * @author dl
 * @date 15.12.2024 18:21
 */
public interface VacancyRepository {

 Vacancy save(Vacancy vacancy);

 void deleteById(int id);

 boolean update(Vacancy vacancy);

 Optional<Vacancy> findById(int id);

 Collection<Vacancy> findAll();

}
