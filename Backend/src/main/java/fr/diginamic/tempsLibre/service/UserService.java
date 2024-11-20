package fr.diginamic.tempsLibre.service;

import fr.diginamic.tempsLibre.DTO.UserDTO;
import fr.diginamic.tempsLibre.mapper.UserMapper;
import fr.diginamic.tempsLibre.model.User;
import fr.diginamic.tempsLibre.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAll() {

        List<UserDTO> users
                = userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();

        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }

        return users;
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found with email: " + email);
        }
        return userMapper.toDTO(user);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (userDTO.getFirstname() != null) {
            user.setFirstname(userDTO.getFirstname());
        }
        if (userDTO.getLastname() != null) {
            user.setLastname(userDTO.getLastname());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getPhoneNumber() != null) {
            user.setPhoneNumber(userDTO.getPhoneNumber());
        }
        if (userDTO.getGender() != null) {
            user.setGender(userDTO.getGender());
        }
        if (userDTO.getRole() != null) {
            user.setRole(userDTO.getRole());
        }
        if (userDTO.getStatus() != null) {
            user.setStatus(userDTO.getStatus());
        }
        if (userDTO.getRemainingLeaveDaysCounter() != 0) {
            user.setRemainingLeaveDaysCounter(userDTO.getRemainingLeaveDaysCounter());
        }

        User updatedUser = userRepository.save(user);

        return userMapper.toDTO(updatedUser);
    }
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setIsDeleted(true);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
    }
}
