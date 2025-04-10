package intern_api.intern.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;




}