package java13.entity;

import java13.enums.Role;
import lombok.*;

/**
 * Author: Bektur Duyshenbek uulu
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class User {
    private Long id;
    private String userName;
    private String password;
    private Role role;

    public User(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
