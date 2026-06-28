package com.example.CRM.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(
        name="notes"
)
public class Note {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "deal_id")  // Kis deal se related hai
    private Deal deal;

    @ManyToOne
    @JoinColumn(name = "contact_id")  // Kis contact ke baare mein
    @NotBlank(message = "Content is required")
    private Contact contact;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
