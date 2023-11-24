package org.jb.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Entity
@Data
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "active")
    private Integer active;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "login")
    private String loginDateTime;
    @Column(name = "logout")
    private String logoutDateTime;
}
