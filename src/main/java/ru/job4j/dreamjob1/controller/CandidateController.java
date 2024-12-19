package ru.job4j.dreamjob1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dreamjob1.model.Candidate;
import ru.job4j.dreamjob1.repository.CandidateRepository;
import ru.job4j.dreamjob1.repository.MemoryCandidateRepository;

import java.util.Optional;

/**
 * @author dl
 * @date 15.12.2024 20:33
 */

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    private final CandidateRepository candidateRepository = MemoryCandidateRepository.getInstance();

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidatesList";
    }

    @GetMapping("/create")
    public String getCreationPage() {
        return "candidates/candidatesCreate";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Candidate candidate) {
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var candidateOptional = candidateRepository.findById(id);
        if (candidateOptional.isEmpty()) {
            model.addAttribute("message", "Candidate with the specified ID was not found.");
            return "error/404";
        }
        model.addAttribute("candidate", candidateOptional.get());
        return "candidates/updateDelete";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Candidate candidate, Model model) {
        var isUpdated = candidateRepository.update(candidate);
        if (!isUpdated) {
            model.addAttribute("message", "Candidate with the specified ID was not found.");
            return "error/404";
        }
        return "redirect:/candidates";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        Optional<Candidate> candidateOptional = candidateRepository.deleteById(id);
        if (candidateOptional.isEmpty()) {
            model.addAttribute("message", "Candidate with the specified ID was not found.");
            return "error/404";
        }
        return "redirect:/candidates";
    }

}
