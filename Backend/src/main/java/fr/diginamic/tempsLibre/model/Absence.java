package fr.diginamic.tempsLibre.model;

import fr.diginamic.tempsLibre.enums.AbsenceStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "absence")
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AbsenceType absenceType;

    @Column(nullable = false)
    private Date beginDate;

    @Column(nullable = false)
    private Date endDate;

    @Column
    private String reason;

    @Column(nullable = false)
    private AbsenceStatus status;
}
