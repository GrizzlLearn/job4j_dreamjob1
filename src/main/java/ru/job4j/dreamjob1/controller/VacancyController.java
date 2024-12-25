package ru.job4j.dreamjob1.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dreamjob1.model.Vacancy;
import ru.job4j.dreamjob1.service.CityService;
import ru.job4j.dreamjob1.service.VacancyService;

import java.util.Optional;

/**
 * @author dl
 * @date 15.12.2024 18:42
 */

@Controller
@ThreadSafe
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;
    private final CityService cityService;

    public VacancyController(VacancyService vacancyService, CityService cityService) {
        this.vacancyService = vacancyService;
        this.cityService = cityService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vacancies", vacancyService.findAll());
        return "vacancies/vacanciesList";
    }

    @GetMapping("/create")
    public String getCreationPage(Model model) {
        model.addAttribute("cities", cityService.findAll());
        return "vacancies/vacanciesCreate";
    }

    //TODO
    @PostMapping("/create")
    public String create(@ModelAttribute Vacancy vacancy) {
        vacancyService.save(vacancy);
        return "redirect:/vacancies";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var vacancyOptional = vacancyService.findById(id);
        if (vacancyOptional.isEmpty()) {
            model.addAttribute("message", "The vacancy with the specified ID was not found.");
            return "error/404";
        }
        model.addAttribute("vacancy", vacancyOptional.get());
        model.addAttribute("cities", cityService.findAll());
        return "vacancies/updateDelete";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Vacancy vacancy, Model model) {
        var isUpdated = vacancyService.update(vacancy);
        if (!isUpdated) {
            model.addAttribute("message", "The vacancy with the specified ID was not found.");
            return "error/404";
        }
        return "redirect:/vacancies";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        Optional<Vacancy> isDeleted = vacancyService.deleteById(id);
        if (isDeleted.isEmpty()) {
            model.addAttribute("message", "The vacancy with the specified ID was not found.");
            return "error/404";
        }
        return "redirect:/vacancies";
    }
}
