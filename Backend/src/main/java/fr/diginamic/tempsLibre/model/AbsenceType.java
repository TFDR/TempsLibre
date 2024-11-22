package fr.diginamic.tempsLibre.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "absence_type")
public class AbsenceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String label;
}