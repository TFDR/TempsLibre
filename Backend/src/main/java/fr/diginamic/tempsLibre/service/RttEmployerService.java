package fr.diginamic.tempsLibre.service;

import fr.diginamic.tempsLibre.DTO.RttEmployerDTO;
import fr.diginamic.tempsLibre.mapper.RttEmployerMapper;
import fr.diginamic.tempsLibre.model.RttEmployer;
import fr.diginamic.tempsLibre.repository.RttEmployerRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class RttEmployerService {

    private final RttEmployerRepository rttEmployerRepository;

    private final RttEmployerMapper rttEmployerMapper;

    public RttEmployerService(RttEmployerRepository rttEmployerRepository, RttEmployerMapper rttEmployerMapper) {
        this.rttEmployerRepository = rttEmployerRepository;
        this.rttEmployerMapper = rttEmployerMapper;
    }

    public List<RttEmployerDTO> getAll() {
        List<RttEmployerDTO> rttEmployers =
                rttEmployerRepository.findAll().stream().map(rttEmployerMapper::toDTO).toList();
        if (rttEmployers.isEmpty()) {
            throw new RuntimeException("No RTT employer found");
        }
        return rttEmployers;
    }

    public RttEmployerDTO findById(Long id) {
        RttEmployer rttEmployer = rttEmployerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No RTT employer found with id: " + id));
        return rttEmployerMapper.toDTO(rttEmployer);
    }

    public RttEmployerDTO findByDate(LocalDate date) {
        RttEmployer rttEmployer = rttEmployerRepository.findByDate(date);
        if (rttEmployer == null) {
            throw new RuntimeException("No RTT employer found at date: " + date);
        }
        return rttEmployerMapper.toDTO(rttEmployer);
    }

    public RttEmployerDTO createRttEmployer(RttEmployerDTO rttEmployerDTO) {
        RttEmployer rttEmployer = rttEmployerRepository.save(rttEmployerMapper.toEntity(rttEmployerDTO));
        return rttEmployerMapper.toDTO(rttEmployer);
    }

    public RttEmployerDTO updateRttEmployer(Long id, RttEmployerDTO rttEmployerDTO) {
        RttEmployer rttEmployer = rttEmployerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No RTT employer found with id: " + id));
        if (rttEmployerDTO.getLabel() != null) {
            rttEmployer.setLabel(rttEmployerDTO.getLabel());
        }
        if (rttEmployerDTO.getDate() != null) {
            rttEmployer.setDate(rttEmployerDTO.getDate());
        }
        if (rttEmployerDTO.getRttEmployerYear() != null) {
            rttEmployer.setRttEmployerYear(rttEmployerDTO.getRttEmployerYear());
        }
        return rttEmployerMapper.toDTO(rttEmployerRepository.save(rttEmployer));
    }

    public void deleteRttEmployer(Long id) {
        rttEmployerRepository.delete(rttEmployerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No RTT employer found with id: " + id)));
    }
}
