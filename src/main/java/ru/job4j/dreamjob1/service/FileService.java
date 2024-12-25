package ru.job4j.dreamjob1.service;

import ru.job4j.dreamjob1.dto.FileDto;
import ru.job4j.dreamjob1.model.File;

import java.util.Optional;

/**
 * @author dl
 * @date 25.12.2024 22:10
 */
public interface FileService {
    File save(FileDto fileDto);
    Optional<FileDto> getFileById(int id);
    void deleteById(int id);
}
