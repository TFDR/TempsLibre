package fr.diginamic.tempsLibre.mapper;

import fr.diginamic.tempsLibre.DTO.RTTEmployerDTO;
import fr.diginamic.tempsLibre.model.RTTEmployer;
import org.springframework.stereotype.Component;

@Component
public class RTTEmployerMapper {

    public RTTEmployer toEntity(RTTEmployerDTO rttEmployerDTO) {
        RTTEmployer rttEmployer = new RTTEmployer();
        rttEmployer.setId(rttEmployerDTO.getId());
        rttEmployer.setLabel(rttEmployerDTO.getLabel());
        rttEmployer.setDate(rttEmployerDTO.getDate());
        rttEmployer.setIdRTTEmployerYear(rttEmployerDTO.getIdRTTEmployerYear());
        return rttEmployer;
    }

    public RTTEmployerDTO toDTO(RTTEmployer rttEmployer) {
        RTTEmployerDTO rttEmployerDTO = new RTTEmployerDTO();
        rttEmployerDTO.setId(rttEmployer.getId());
        rttEmployerDTO.setLabel(rttEmployer.getLabel());
        rttEmployerDTO.setDate(rttEmployer.getDate());
        rttEmployerDTO.setIdRTTEmployerYear(rttEmployer.getIdRTTEmployerYear());
        return rttEmployerDTO;
    }
}
