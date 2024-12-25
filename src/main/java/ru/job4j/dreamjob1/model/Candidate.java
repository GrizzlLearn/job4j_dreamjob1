package ru.job4j.dreamjob1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author dl
 * @date 15.12.2024 19:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    private int id;
    private String name;
    private String description;
    private LocalDateTime creationDate = LocalDateTime.now();
    private int cityId;
}
