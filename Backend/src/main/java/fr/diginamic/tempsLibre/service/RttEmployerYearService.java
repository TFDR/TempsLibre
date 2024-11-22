package fr.diginamic.tempsLibre.service;

import fr.diginamic.tempsLibre.DTO.RttEmployerYearDTO;
import fr.diginamic.tempsLibre.mapper.RttEmployerYearMapper;
import fr.diginamic.tempsLibre.model.RttEmployerYear;
import fr.diginamic.tempsLibre.repository.RttEmployerYearRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RttEmployerYearService {
    private final RttEmployerYearRepository rttEmployerYearRepository;

    private final RttEmployerYearMapper rttEmployerYearMapper;

    public RttEmployerYearService(RttEmployerYearRepository rttEmployerYearRepository, RttEmployerYearMapper rttEmployerYearMapper) {
        this.rttEmployerYearRepository = rttEmployerYearRepository;
        this.rttEmployerYearMapper = rttEmployerYearMapper;
    }

    public List<RttEmployerYearDTO> getAll() {
        List<RttEmployerYearDTO> rttEmployersYear =
                rttEmployerYearRepository.findAll().stream().map(rttEmployerYearMapper::toDTO).toList();
        if (rttEmployersYear.isEmpty()) {
            throw new RuntimeException("No RTT employer year found");
        }
        return rttEmployersYear;
    }

    public RttEmployerYearDTO findById(Long id) {
        RttEmployerYear rttEmployerYear = rttEmployerYearRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No RTT employer year found with id: " + id));
        return rttEmployerYearMapper.toDTO(rttEmployerYear);
    }
    public RttEmployerYearDTO createRttEmployerYear(RttEmployerYearDTO rttEmployerYearDTO) {
        RttEmployerYear rttEmployerYear = rttEmployerYearRepository.save(rttEmployerYearMapper.toEntity(rttEmployerYearDTO));
        return rttEmployerYearMapper.toDTO(rttEmployerYear);
    }

    public RttEmployerYearDTO updateRttEmployerYear(Long id, RttEmployerYearDTO rttEmployerYearDTO) {
        RttEmployerYear rttEmployerYear = rttEmployerYearRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No RTT employer year found with id: " + id));
        if (rttEmployerYearDTO.getInitialCounter() != null) {
            rttEmployerYear.setInitialCounter(rttEmployerYearDTO.getInitialCounter());
        }
        if (rttEmployerYearDTO.getRemainingCounter() != null) {
            rttEmployerYear.setRemainingCounter(rttEmployerYearDTO.getRemainingCounter());
        }
        if (rttEmployerYearDTO.getRttYear() != null) {
            rttEmployerYear.setRttYear(rttEmployerYearDTO.getRttYear());
        }
        return rttEmployerYearMapper.toDTO(rttEmployerYearRepository.save(rttEmployerYear));
    }

    public void deleteRttEmployerYear(Long id) {
        rttEmployerYearRepository.delete(rttEmployerYearRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No RTT employer year found with id: " + id)));
    }
}
