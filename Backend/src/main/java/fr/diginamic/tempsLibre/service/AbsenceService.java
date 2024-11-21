package fr.diginamic.tempsLibre.service;

import fr.diginamic.tempsLibre.DTO.AbsenceDTO;
import fr.diginamic.tempsLibre.DTO.UserDTO;
import fr.diginamic.tempsLibre.mapper.AbsenceMapper;
import fr.diginamic.tempsLibre.mapper.UserMapper;
import fr.diginamic.tempsLibre.model.Absence;
import fr.diginamic.tempsLibre.model.User;
import fr.diginamic.tempsLibre.repository.AbsenceRepository;
import fr.diginamic.tempsLibre.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final AbsenceMapper absenceMapper;

    public AbsenceService(AbsenceRepository absenceRepository, AbsenceMapper absenceMapper) {
        this.absenceRepository = absenceRepository;
        this.absenceMapper = absenceMapper;
    }

    public List<AbsenceDTO> getAll() {
        List<AbsenceDTO> absences
                = absenceRepository.findAll()
                .stream()
                .map(absenceMapper::toDTO)
                .toList();
        if (absences.isEmpty()) throw new RuntimeException("No absences found");

        return absences;
    }

    public AbsenceDTO findById(Long id) {
        Absence absence = absenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence not found with id: " + id));
        return absenceMapper.toDTO(absence);
    }

    public AbsenceDTO findByAbsenceType(String absenceType) {
        Absence absence = absenceRepository.findByAbsenceType(absenceType);
        if (absence == null) throw new RuntimeException("Absence not found with absenceType: " + absenceType);

        return absenceMapper.toDTO(absence);
    }

    public AbsenceDTO createAbsence(AbsenceDTO absenceDTO) {
        Absence absence = absenceMapper.toEntity(absenceDTO);
        Absence savedAbsence = absenceRepository.save(absence);
        return absenceMapper.toDTO(savedAbsence);
    }

    public AbsenceDTO updateAbsence(Long id, AbsenceDTO absenceDTO) {
        Absence absence = absenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence not found with id: " + id));

        if (absenceDTO.getAbsenceType() != null) absence.setAbsenceType(absenceDTO.getAbsenceType());
        if (absenceDTO.getBeginDate() != null) absence.setBeginDate(absenceDTO.getBeginDate());
        if (absenceDTO.getEndDate() != null) absence.setEndDate(absenceDTO.getEndDate());
        if (absenceDTO.getReason() != null) absence.setReason(absenceDTO.getReason());
        if (absenceDTO.getStatus() != null) absence.setStatus(absenceDTO.getStatus());

        Absence updatedAbsence = absenceRepository.save(absence);
        return absenceMapper.toDTO(updatedAbsence);
    }

    public void deleteAbsence(Long id) {
        Absence absence = absenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence not found with id: " + id));
        absenceRepository.delete(absence);
    }

}
