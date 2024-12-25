package ru.job4j.dreamjob1.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob1.model.City;
import ru.job4j.dreamjob1.repository.CityRepository;

import java.util.Collection;
import java.util.List;

/**
 * @author dl
 * @date 25.12.2024 20:45
 */
@Service
@ThreadSafe
public class SimpleCityService implements CityService {
    private final CityRepository cityRepository;

    public SimpleCityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Collection<City> findAll() {
        return cityRepository.findAll();
    }
}
