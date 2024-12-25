package ru.job4j.dreamjob1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author dl
 * @date 25.12.2024 21:57
 */

@Data
@RequiredArgsConstructor
public class File {
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String path;
}
