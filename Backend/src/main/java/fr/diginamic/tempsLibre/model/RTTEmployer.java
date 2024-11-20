package fr.diginamic.tempsLibre.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class RTTEmployer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;
}