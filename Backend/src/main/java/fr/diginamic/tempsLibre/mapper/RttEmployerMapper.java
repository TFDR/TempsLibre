package fr.diginamic.tempsLibre.mapper;
import fr.diginamic.tempsLibre.DTO.RttEmployerDTO;
import fr.diginamic.tempsLibre.model.RttEmployer;
import org.springframework.stereotype.Component;

@Component
public class RttEmployerMapper {

    public RttEmployer toEntity(RttEmployerDTO rttEmployerDTO) {
        RttEmployer rttEmployer = new RttEmployer();
        rttEmployer.setId(rttEmployerDTO.getId());
        rttEmployer.setLabel(rttEmployerDTO.getLabel());
        rttEmployer.setDate(rttEmployerDTO.getDate());
        rttEmployer.setRttEmployerYear(rttEmployerDTO.getRttEmployerYear());
        return rttEmployer;
    }

    public RttEmployerDTO toDTO(RttEmployer rttEmployer) {
        RttEmployerDTO rttEmployerDTO = new RttEmployerDTO();
        rttEmployerDTO.setId(rttEmployer.getId());
        rttEmployerDTO.setLabel(rttEmployer.getLabel());
        rttEmployerDTO.setDate(rttEmployer.getDate());
        rttEmployerDTO.setRttEmployerYear(rttEmployer.getRttEmployerYear());
        return rttEmployerDTO;
    }
}
