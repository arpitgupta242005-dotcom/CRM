package com.example.CRM.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(
        name="companies"
)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;

    @Column(unique = true)
    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;
    private String IndustryType;//e.g IT,finance,healthcare
    @NotBlank(message = "Phone is required")
    private String  phone;
    private String  website;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt=LocalDateTime.now();
    }

}
