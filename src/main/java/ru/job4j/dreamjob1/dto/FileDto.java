package ru.job4j.dreamjob1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dl
 * @date 25.12.2024 22:09
 */

@Data
@AllArgsConstructor
public class FileDto {
    private String name;
    private byte[] content;
}
