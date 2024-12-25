package ru.job4j.dreamjob1.repository;

import ru.job4j.dreamjob1.model.File;

import java.util.Optional;

/**
 * @author dl
 * @date 25.12.2024 22:03
 */
public interface FileRepository {
    File save(File file);
    Optional<File> findById(int id);
    void deleteById(int id);
}
