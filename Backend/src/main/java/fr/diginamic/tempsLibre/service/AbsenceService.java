package fr.diginamic.tempsLibre.service;

import fr.diginamic.tempsLibre.DTO.AbsenceDTO;
import fr.diginamic.tempsLibre.DTO.AbsenceTypeDTO;
import fr.diginamic.tempsLibre.mapper.AbsenceMapper;
import fr.diginamic.tempsLibre.mapper.AbsenceTypeMapper;
import fr.diginamic.tempsLibre.model.Absence;
import fr.diginamic.tempsLibre.model.AbsenceType;
import fr.diginamic.tempsLibre.repository.AbsenceRepository;
import fr.diginamic.tempsLibre.repository.AbsenceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private AbsenceMapper absenceMapper;


    @Autowired
    public AbsenceService(AbsenceRepository absenceRepository, AbsenceMapper absenceMapper) {
        this.absenceRepository = absenceRepository;
        this.absenceMapper = absenceMapper;
    }

    public List<AbsenceDTO> getAll() {
        List<AbsenceDTO> absencesDTO
                = absenceRepository.findAll()
                .stream()
                .map(absenceMapper::toDTO)
                .toList();

        if (absencesDTO.isEmpty()) {
            throw new RuntimeException("No absences found");
        }
        return absencesDTO;
    }

    public AbsenceDTO findById(Long id) {
        Absence absence = absenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence not found with id: " + id));
        return absenceMapper.toDTO(absence);
    }

    public AbsenceDTO findByEmployee_Id(Long employeeId) {
        Absence absence = absenceRepository.findByEmployee_Id(employeeId);
        if (absence == null) {
            throw new RuntimeException("Absence not found with employee id: " + employeeId);
        }
        return absenceMapper.toDTO(absence);
    }

    public AbsenceDTO findByAbsenceType_Id(Long absenceTypeId) {
        Absence absence = absenceRepository.findByAbsenceType_Id(absenceTypeId);
        if (absence == null) {
            throw new RuntimeException("Absence not found with absence type id: " + absenceTypeId);
        }
        return absenceMapper.toDTO(absence);
    }

    public AbsenceDTO findByBeginDate(Date beginDate) {
        Absence absence = absenceRepository.findByBeginDate(beginDate);
        if (absence == null) {
            throw new RuntimeException("Absence not found with begin date: " + beginDate);
        }
        return absenceMapper.toDTO(absence);
    }

    public AbsenceDTO findByEndDate(Date endDate) {
        Absence absence = absenceRepository.findByEndDate(endDate);
        if (absence == null) {
            throw new RuntimeException("Absence not found with end date: " + endDate);
        }
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
        absence.setEmployee(absenceDTO.getEmployee());
        absence.setAbsenceType(absenceDTO.getAbsenceType());
        absence.setBeginDate(absenceDTO.getBeginDate());
        absence.setEndDate(absenceDTO.getEndDate());
        Absence updatedAbsence = absenceRepository.save(absence);
        return absenceMapper.toDTO(updatedAbsence);
    }

    public void deleteAbsence(Long id) {
        Absence absence = absenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence not found with id: " + id));
        absenceRepository.delete(absence);
    }


}
