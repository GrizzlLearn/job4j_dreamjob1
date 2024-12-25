package ru.job4j.dreamjob1.repository;

import ru.job4j.dreamjob1.model.City;

import java.util.Collection;

/**
 * @author dl
 * @date 25.12.2024 20:39
 */
public interface CityRepository {
    Collection<City> findAll();
}
