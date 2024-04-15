package com.orange.Authentification.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Jwt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean desactive;
    private boolean expire;
    private User user ;

}
