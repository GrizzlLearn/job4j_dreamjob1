package ru.job4j.dreamjob1.repository;

import ru.job4j.dreamjob1.model.Vacancy;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author dl
 * @date 15.12.2024 18:21
 */
public class MemoryVacancyRepository implements VacancyRepository {

    private static final MemoryVacancyRepository INSTANCE = new MemoryVacancyRepository();

    private int nextId = 1;

    private final Map<Integer, Vacancy> vacancies = new HashMap<>();

    private MemoryVacancyRepository() {
        save(new Vacancy(0, "Intern Java Developer", "Intern Java Developer", LocalDateTime.now()));
        save(new Vacancy(0, "Junior Java Developer", "Junior Java Developer", LocalDateTime.now()));
        save(new Vacancy(0, "Junior+ Java Developer", "Junior+ Java Developer", LocalDateTime.now()));
        save(new Vacancy(0, "Middle Java Developer", "Middle Java Developer", LocalDateTime.now()));
        save(new Vacancy(0, "Middle+ Java Developer", "Middle+ Java Developer", LocalDateTime.now()));
        save(new Vacancy(0, "Senior Java Developer", "Senior Java Developer", LocalDateTime.now()));
    }

    public static MemoryVacancyRepository getInstance() {
        return INSTANCE;
    }

    /**
     * Сохраняет объект Vacancy в карту
     * @param vacancy
     * @return Vacancy
     */
    @Override
    public Vacancy save(Vacancy vacancy) {
        vacancy.setId(nextId++);
        vacancies.put(vacancy.getId(), vacancy);
        return vacancy;
    }

    /**
     * Удаляет из карты объект Vacancy по его id
     * @param id
     */
    @Override
    public Optional<Vacancy> deleteById(int id) {
        return Optional.ofNullable(vacancies.remove(id));
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return vacancies.computeIfPresent(vacancy.getId(),
                (id, oldVacancy) -> new Vacancy(oldVacancy.getId(), vacancy.getTitle(), vacancy.getDescription(), vacancy.getCreationDate())) != null;
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return Optional.ofNullable(vacancies.get(id));
    }

    @Override
    public Collection<Vacancy> findAll() {
        return vacancies.values();
    }
}
