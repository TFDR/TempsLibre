package fr.diginamic.tempsLibre.controller;

import fr.diginamic.tempsLibre.DTO.RttEmployerDTO;
import fr.diginamic.tempsLibre.service.RttEmployerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/RttEmployers")
public class RttEmployerController {

    private final RttEmployerService rttEmployerService;

    public RttEmployerController(RttEmployerService rttEmployerService) {
        this.rttEmployerService = rttEmployerService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<RttEmployerDTO>> getAllRttEmployer() {
        try {
            List<RttEmployerDTO> rttEmployers = rttEmployerService.getAll();
            return ResponseEntity.ok(rttEmployers);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RttEmployerDTO> getRttEmployerById(@PathVariable Long id) {
        try {
            RttEmployerDTO rttEmployer = rttEmployerService.findById(id);
            return ResponseEntity.ok(rttEmployer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/date/{date}")
    public ResponseEntity<RttEmployerDTO> getRttEmployerByDate(@PathVariable LocalDate date) {
        try {
            RttEmployerDTO rttEmployer = rttEmployerService.findByDate(date);
            return ResponseEntity.ok(rttEmployer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<RttEmployerDTO> createRttEmployer(@RequestBody RttEmployerDTO rttEmployerDTO) {
        RttEmployerDTO rttEmployerDTOCreated = rttEmployerService.createRttEmployer(rttEmployerDTO);
        return ResponseEntity.ok(rttEmployerDTOCreated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RttEmployerDTO> updateRttEmployer(@PathVariable Long id, @RequestBody RttEmployerDTO rttEmployerDTO) {
        RttEmployerDTO updatedRttEmployer = rttEmployerService.updateRttEmployer(id, rttEmployerDTO);
        return ResponseEntity.ok(updatedRttEmployer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRttEmployer(@PathVariable Long id) {
        try {
            rttEmployerService.deleteRttEmployer(id);
            return ResponseEntity.ok("RTT employer deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
