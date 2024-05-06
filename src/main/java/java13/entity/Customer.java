package java13.entity;

import lombok.*;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Setter
@Getter@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
private Long id;
private String firstName;
private String lastName;
private String phoneNumber;
}
