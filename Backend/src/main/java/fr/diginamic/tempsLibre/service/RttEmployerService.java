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

    public RttEmployerDTO findByDate(LocalDate date) {
        RttEmployer rttEmployer = rttEmployerRepository.findByDate(date);
        if (rttEmployer == null) {
            throw new RuntimeException("No RTT employer found at date: " + date);
        }
        return rttEmployerMapper.toDTO(rttEmployer);
    }
}
