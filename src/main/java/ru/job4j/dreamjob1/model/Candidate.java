package ru.job4j.dreamjob1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dl
 * @date 15.12.2024 19:19
 */

@Data
@AllArgsConstructor
public class Candidate {
    private int id;
    private String name;
    private String description;
    private String creationDate;
}
