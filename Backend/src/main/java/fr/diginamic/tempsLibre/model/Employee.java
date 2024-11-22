package fr.diginamic.tempsLibre.model;

import fr.diginamic.tempsLibre.enums.EmployeeStatus;
import fr.diginamic.tempsLibre.enums.Gender;
import fr.diginamic.tempsLibre.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EMPLOYEE")
@SQLDelete(sql = "UPDATE EMPLOYEE SET is_deleted = true, deleted_at = NOW() WHERE id = ?")
@Where(clause = "is_deleted = false") // Cette annotation permet d'exclure tous les employés qui ont is_deleted à true
public class Employee {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.EMPLOYEE;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus status;

    @Builder.Default
    @Column(nullable = false)
    private Integer remainingLeaveDaysCounter = 25;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_DEPARTMENT", nullable=false)
    private Department department;
}
