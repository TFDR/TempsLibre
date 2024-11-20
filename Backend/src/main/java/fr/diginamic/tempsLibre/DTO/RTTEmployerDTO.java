package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.model.RTTEmployerYear;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RTTEmployerDTO {
    private Long id;
    private String label;
    private LocalDateTime date;
    private RTTEmployerYear idRTTEmployerYear;
}