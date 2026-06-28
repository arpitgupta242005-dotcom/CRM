package com.example.CRM.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(
        name="deals"
)
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Title is required")
    private String title;//deal ka name e.g infosys software deal
    @NotNull(message = "Value is required")
    private Double value;//deal ki vale e.g  50k

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Stage is required")
    private DealStage stage;
    @PrePersist
    public void prePersist(){
        this.createdAt=LocalDateTime.now();
        if(this.stage==null){
            this.stage=DealStage.PROSPECTING;
        }
    }

}
