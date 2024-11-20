package fr.diginamic.tempsLibre.DTO;

import lombok.Data;

@Data
public class RTTEmployerYearDTO {
    private Long id;
    private Integer initialCounter;
    private Integer remainingCounter;
    private Integer year;
}
