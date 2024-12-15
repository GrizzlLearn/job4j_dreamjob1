package ru.job4j.dreamjob1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.dreamjob1.repository.CandidateRepository;
import ru.job4j.dreamjob1.repository.MemoryCandidateRepository;

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
}
