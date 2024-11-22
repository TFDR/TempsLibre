package fr.diginamic.tempsLibre.controller;

import fr.diginamic.tempsLibre.DTO.AbsenceDTO;
import fr.diginamic.tempsLibre.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @GetMapping
    public ResponseEntity<List<AbsenceDTO>> getAll() {
        return ResponseEntity.ok(absenceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbsenceDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(absenceService.findById(id));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<AbsenceDTO> getByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(absenceService.findByEmployee_Id(employeeId));
    }

    @GetMapping("/absenceType/{absenceTypeId}")
    public ResponseEntity<AbsenceDTO> getByAbsenceTypeId(@PathVariable Long absenceTypeId) {
        return ResponseEntity.ok(absenceService.findByAbsenceType_Id(absenceTypeId));
    }

    @GetMapping("/beginDate/{beginDate}")
    public ResponseEntity<AbsenceDTO> getByBeginDate(@PathVariable Date beginDate) {
        return ResponseEntity.ok(absenceService.findByBeginDate(beginDate));
    }

    @GetMapping("/endDate/{endDate}")
    public ResponseEntity<AbsenceDTO> getByEndDate(@PathVariable Date endDate) {
        return ResponseEntity.ok(absenceService.findByEndDate(endDate));
    }

    @PostMapping
    public ResponseEntity<AbsenceDTO> createAbsence(@RequestBody AbsenceDTO absenceDTO) {
        return ResponseEntity.ok(absenceService.createAbsence(absenceDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbsenceDTO> updateAbsence(@PathVariable Long id, @RequestBody AbsenceDTO absenceDTO) {
        return ResponseEntity.ok(absenceService.updateAbsence(id, absenceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long id) {
        absenceService.deleteAbsence(id);
        return ResponseEntity.noContent().build();
    }
}
