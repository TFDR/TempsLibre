package fr.diginamic.tempsLibre.mapper;

import fr.diginamic.tempsLibre.DTO.RttEmployerYearDTO;
import fr.diginamic.tempsLibre.model.RttEmployerYear;
import org.springframework.stereotype.Component;

@Component
public class RTTEmployerYearMapper {

    public RttEmployerYear toEntity(RttEmployerYearDTO rttEmployerYearDTO) {
        RttEmployerYear rttEmployerYear =new RttEmployerYear();
        rttEmployerYear.setId(rttEmployerYearDTO.getId());
        rttEmployerYear.setInitialCounter(rttEmployerYearDTO.getInitialCounter());
        rttEmployerYear.setRemainingCounter(rttEmployerYearDTO.getRemainingCounter());
        rttEmployerYear.setYear(rttEmployerYearDTO.getYear());
        return rttEmployerYear;
    }

    public RttEmployerYearDTO toDTO(RttEmployerYear rttEmployerYear) {
        RttEmployerYearDTO rttEmployerYearDTO =new RttEmployerYearDTO();
        rttEmployerYearDTO.setId(rttEmployerYear.getId());
        rttEmployerYearDTO.setInitialCounter(rttEmployerYear.getInitialCounter());
        rttEmployerYearDTO.setRemainingCounter(rttEmployerYear.getRemainingCounter());
        rttEmployerYearDTO.setYear(rttEmployerYear.getYear());
        return rttEmployerYearDTO;
    }
}