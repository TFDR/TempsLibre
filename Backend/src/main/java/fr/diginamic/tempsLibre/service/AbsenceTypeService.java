package fr.diginamic.tempsLibre.service;

import fr.diginamic.tempsLibre.DTO.AbsenceTypeDTO;
import fr.diginamic.tempsLibre.mapper.AbsenceTypeMapper;
import fr.diginamic.tempsLibre.model.AbsenceType;
import fr.diginamic.tempsLibre.repository.AbsenceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceTypeService {

    @Autowired
    private AbsenceTypeRepository absenceTypeRepository;

    @Autowired
    private AbsenceTypeMapper absenceTypeMapper;


    @Autowired
    public AbsenceTypeService(AbsenceTypeRepository absenceTypeRepository, AbsenceTypeMapper absenceTypeMapper) {
        this.absenceTypeRepository = absenceTypeRepository;
        this.absenceTypeMapper = absenceTypeMapper;
    }

    public List<AbsenceTypeDTO> getAll() {
        List<AbsenceTypeDTO> absenceTypes
                = absenceTypeRepository.findAll()
                .stream()
                .map(absenceTypeMapper::toDTO)
                .toList();

        if (absenceTypes.isEmpty()) {
            throw new RuntimeException("No absence types found");
        }
        return absenceTypes;
    }

    public AbsenceTypeDTO findById(Long id) {
        AbsenceType absenceType = absenceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence type not found with id: " + id));
        return absenceTypeMapper.toDTO(absenceType);
    }

    public AbsenceTypeDTO findByLabel(String label) {
        AbsenceType absenceType = absenceTypeRepository.findByLabel(label);
        if (absenceType == null) {
            throw new RuntimeException("Absence type not found with label: " + label);
        }
        return absenceTypeMapper.toDTO(absenceType);
    }

    public AbsenceTypeDTO createAbsenceType(AbsenceTypeDTO absenceTypeDTO) {
        AbsenceType absenceType = absenceTypeMapper.toEntity(absenceTypeDTO);
        AbsenceType savedAbsenceType = absenceTypeRepository.save(absenceType);
        return absenceTypeMapper.toDTO(savedAbsenceType);
    }

    public AbsenceTypeDTO updateAbsenceType(Long id, AbsenceTypeDTO absenceTypeDTO) {
        AbsenceType absenceType = absenceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence type not found with id: " + id));
        absenceType.setLabel(absenceTypeDTO.getLabel());
        AbsenceType updatedAbsenceType = absenceTypeRepository.save(absenceType);
        return absenceTypeMapper.toDTO(updatedAbsenceType);
    }

    public void deleteAbsenceType(Long id) {
        AbsenceType absenceType = absenceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Absence type not found with id: " + id));
        absenceTypeRepository.delete(absenceType);
    }
}
