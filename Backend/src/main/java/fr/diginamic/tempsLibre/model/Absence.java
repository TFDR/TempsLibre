package fr.diginamic.tempsLibre.model;

import fr.diginamic.tempsLibre.enums.AbsenceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "absence")
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date beginDate;

    @Column(nullable = false)
    private Date endDate;

    @Column
    private String reason;

    @Enumerated(EnumType.STRING)
    private AbsenceStatus status;

    @ManyToOne
    @JoinColumn(name = "absence_type_id")
    private AbsenceType absenceType;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private User employee;
}