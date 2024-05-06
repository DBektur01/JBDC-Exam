package java13.entity;

import lombok.*;

/**
 * Author: Bektur Duyshenbek uulu
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter @Getter
public class Course {
    private Long id;
    private String name;
    private String description;
    private int duration;

    public Course(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }
}
