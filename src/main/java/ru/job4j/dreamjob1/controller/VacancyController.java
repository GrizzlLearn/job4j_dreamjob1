package ru.job4j.dreamjob1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.dreamjob1.repository.MemoryVacancyRepository;
import ru.job4j.dreamjob1.repository.VacancyRepository;

/**
 * @author dl
 * @date 15.12.2024 18:42
 */

@Controller
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyRepository vacancyRepository = MemoryVacancyRepository.getInstance();

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vacancies", vacancyRepository.findAll());
        return "vacancies/vacanciesList";
    }
}
