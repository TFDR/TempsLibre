package fr.diginamic.tempsLibre.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "RTT_EMPLOYER")
@Data
public class RttEmployer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "DATE", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_RTT_EMPLOYER_YEAR", nullable = false)
    private RttEmployerYear rttEmployerYear;
}