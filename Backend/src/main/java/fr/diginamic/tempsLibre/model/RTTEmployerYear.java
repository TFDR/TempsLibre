package fr.diginamic.tempsLibre.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class RTTEmployerYear {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "INITIAL_COUNTER", nullable = false)
    private Integer initialCounter;

    @Column(name = "REMAINING_COUNTER", nullable = false)
    private Integer remainingCounter;

    @Column(name = "YEAR", nullable = false)
    private Integer year;
}