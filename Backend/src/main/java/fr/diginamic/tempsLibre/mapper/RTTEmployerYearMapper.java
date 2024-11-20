package fr.diginamic.tempsLibre.mapper;

import fr.diginamic.tempsLibre.DTO.RTTEmployerYearDTO;
import fr.diginamic.tempsLibre.model.RTTEmployerYear;
import org.springframework.stereotype.Component;

@Component
public class RTTEmployerYearMapper {

    public RTTEmployerYear toEntity(RTTEmployerYearDTO rttEmployerYearDTO) {
        RTTEmployerYear rttEmployerYear =new RTTEmployerYear();
        rttEmployerYear.setId(rttEmployerYearDTO.getId());
        rttEmployerYear.setInitialCounter(rttEmployerYearDTO.getInitialCounter());
        rttEmployerYear.setRemainingCounter(rttEmployerYearDTO.getRemainingCounter());
        rttEmployerYear.setYear(rttEmployerYearDTO.getYear());
        return rttEmployerYear;
    }

    public RTTEmployerYearDTO toDTO(RTTEmployerYear rttEmployerYear) {
        RTTEmployerYearDTO rttEmployerYearDTO =new RTTEmployerYearDTO();
        rttEmployerYearDTO.setId(rttEmployerYear.getId());
        rttEmployerYearDTO.setInitialCounter(rttEmployerYear.getInitialCounter());
        rttEmployerYearDTO.setRemainingCounter(rttEmployerYear.getRemainingCounter());
        rttEmployerYearDTO.setYear(rttEmployerYear.getYear());
        return rttEmployerYearDTO;
    }
}
