package ru.job4j.dreamjob1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author dl
 * @date 15.12.2024 18:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {
    private int id;
    private String title;
    private String description;
    private LocalDateTime creationDate = LocalDateTime.now();
    private boolean visible;
    private int cityId;

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
