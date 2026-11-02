package com.titan.tune.domain.model;
import jakarta.persistence.*; import lombok.Data; import java.util.UUID;

@Entity @Data @Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID trackingId;
    private String firstName; private String lastName; @Column(unique=true) private String email;
    private String password; private String phone; private boolean enabled=false;
    private String role; private String alias; private String description;
}