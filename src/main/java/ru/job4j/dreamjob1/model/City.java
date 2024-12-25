package ru.job4j.dreamjob1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dl
 * @date 25.12.2024 20:38
 */

@Data
@AllArgsConstructor
public class City {
    private final int id;
    private final String name;
}
