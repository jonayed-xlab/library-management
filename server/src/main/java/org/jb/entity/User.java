package org.jb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "active")
    private Integer active;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "dob")
    private String dateOfBirth;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "department")
    private String department;
    @Column(name = "enroll_year")
    private Integer enrollYear;
    @Column(name = "present_address")
    private String presentAddress;
    @Column(name = "permanent_address")
    private String permanentAddress;
    @Column(name = "password")
    private String password;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "photo_id")
    private Long photoId;


}
