package ru.job4j.dreamjob1.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob1.model.File;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dl
 * @date 25.12.2024 22:04
 */

@Repository
public class MemoryFileRepository implements FileRepository {
    private final AtomicInteger nextId = new AtomicInteger(0);
    private final Map<Integer, File> files = new ConcurrentHashMap<>();

    @Override
    public File save(File file) {
        file.setId(nextId.incrementAndGet());
        files.put(file.getId(), file);
        return file;
    }

    @Override
    public Optional<File> findById(int id) {
        return Optional.ofNullable(files.get(id));
    }

    @Override
    public void deleteById(int id) {
        files.remove(id);
    }
}
