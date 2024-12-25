package ru.job4j.dreamjob1.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob1.dto.FileDto;
import ru.job4j.dreamjob1.model.Vacancy;
import ru.job4j.dreamjob1.repository.VacancyRepository;
import java.util.Collection;
import java.util.Optional;

/**
 * @author dl
 * @date 21.12.2024 19:47
 */

@Service
@ThreadSafe
public class SimpleVacancyService implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final FileService fileService;

    public SimpleVacancyService(VacancyRepository vacancyRepository, FileService fileService) {
        this.vacancyRepository = vacancyRepository;
        this.fileService = fileService;
    }

    @Override
    public Vacancy save(Vacancy vacancy, FileDto image) {
        saveNewFile(vacancy, image);
        return vacancyRepository.save(vacancy);
    }

    private void saveNewFile(Vacancy vacancy, FileDto image) {
        var file = fileService.save(image);
        vacancy.setFileId(file.getId());
    }

    @Override
    public Optional<Vacancy> deleteById(int id) {
        var fileOptional = findById(id);
        fileOptional.ifPresent(vacancyFile -> fileService.deleteById(vacancyFile.getFileId()));
        return vacancyRepository.deleteById(id);
    }

    @Override
    public boolean update(Vacancy vacancy, FileDto image) {
        var isNewFileEmpty = image.getContent().length == 0;
        if (isNewFileEmpty) {
            return vacancyRepository.update(vacancy);
        }
        var oldFileId = vacancy.getFileId();
        saveNewFile(vacancy, image);
        var isUpdated = vacancyRepository.update(vacancy);
        fileService.deleteById(oldFileId);
        return isUpdated;
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
