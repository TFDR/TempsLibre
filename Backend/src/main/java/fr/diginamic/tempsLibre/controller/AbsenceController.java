package fr.diginamic.tempsLibre.controller;

import fr.diginamic.tempsLibre.DTO.AbsenceDTO;
import fr.diginamic.tempsLibre.DTO.UserDTO;
import fr.diginamic.tempsLibre.service.AbsenceService;
import fr.diginamic.tempsLibre.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<AbsenceDTO>> getAllAbsences() {
        try {
            List<AbsenceDTO> absences = absenceService.getAll();
            return ResponseEntity.ok(absences);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AbsenceDTO> getAbsenceById(@PathVariable Long id) {
        try {
            AbsenceDTO absence = absenceService.findById(id);
            return ResponseEntity.ok(absence);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/absenceType/{absenceType}")
    public ResponseEntity<AbsenceDTO> getAbsenceByAbsenceType(@PathVariable String absenceType) {
        try {
            AbsenceDTO absence = absenceService.findByAbsenceType(absenceType);
            return ResponseEntity.ok(absence);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<AbsenceDTO> createAbsence(@RequestBody AbsenceDTO absenceDTO) {
        AbsenceDTO createdAbsence = absenceService.createAbsence(absenceDTO);
        return ResponseEntity.ok(createdAbsence);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AbsenceDTO> updateAbsence(@PathVariable Long id, @RequestBody AbsenceDTO absenceDTO) {
        try {
            AbsenceDTO updatedAbsence = absenceService.updateAbsence(id, absenceDTO);
            return ResponseEntity.ok(updatedAbsence);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long id) {
        try {
            absenceService.deleteAbsence(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
