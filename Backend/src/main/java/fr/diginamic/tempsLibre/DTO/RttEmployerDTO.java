package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.model.RttEmployerYear;
import lombok.Data;
import java.time.LocalDate;

@Data
public class RttEmployerDTO {
    private Long id;
    private String label;
    private LocalDate date;
    private RttEmployerYear rttEmployerYear;
}