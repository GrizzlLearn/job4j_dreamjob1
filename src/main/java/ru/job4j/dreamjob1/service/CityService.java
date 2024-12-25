package ru.job4j.dreamjob1.service;

import ru.job4j.dreamjob1.model.City;

import java.util.Collection;

/**
 * @author dl
 * @date 25.12.2024 20:44
 */
public interface CityService {
    Collection<City> findAll();
}
