package fr.diginamic.tempsLibre.controller;

import fr.diginamic.tempsLibre.DTO.RttEmployerYearDTO;
import fr.diginamic.tempsLibre.service.RttEmployerYearService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/RttEmployersYear")
public class RttEmployerYearController {

    private final RttEmployerYearService rttEmployerYearService;

    public RttEmployerYearController(RttEmployerYearService rttEmployerYearService) {
        this.rttEmployerYearService = rttEmployerYearService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<RttEmployerYearDTO>> getAllRttEmployerYear() {
        try {
            List<RttEmployerYearDTO> rttEmployersYear = rttEmployerYearService.getAll();
            return ResponseEntity.ok(rttEmployersYear);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RttEmployerYearDTO> getRttEmployerYearById(@PathVariable Long id) {
        try {
            RttEmployerYearDTO rttEmployer = rttEmployerYearService.findById(id);
            return ResponseEntity.ok(rttEmployer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<RttEmployerYearDTO> createEmployerYear(@RequestBody RttEmployerYearDTO rttEmployerYearDTO) {
        RttEmployerYearDTO rttEmployerYearDTOCreated = rttEmployerYearService.createRttEmployerYear(rttEmployerYearDTO);
        return ResponseEntity.ok(rttEmployerYearDTOCreated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RttEmployerYearDTO> updateEmployee(@PathVariable Long id, @RequestBody RttEmployerYearDTO rttEmployerYearDTO) {
        RttEmployerYearDTO updatedRttEmployerYear = rttEmployerYearService.updateRttEmployerYear(id, rttEmployerYearDTO);
        return ResponseEntity.ok(updatedRttEmployerYear);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployerYear(@PathVariable Long id) {
        try {
            rttEmployerYearService.deleteRttEmployerYear(id);
            return ResponseEntity.ok("RTT employer year deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
