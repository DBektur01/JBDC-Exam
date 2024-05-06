package java13.entity;

import lombok.*;

import java.time.LocalDate;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public Project(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
