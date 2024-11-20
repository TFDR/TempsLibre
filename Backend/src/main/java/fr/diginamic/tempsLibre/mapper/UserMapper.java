package fr.diginamic.tempsLibre.mapper;

import fr.diginamic.tempsLibre.DTO.UserDTO;
import fr.diginamic.tempsLibre.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setGender(userDTO.getGender());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        user.setRemainingLeaveDaysCounter(userDTO.getRemainingLeaveDaysCounter());
        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setGender(user.getGender());
        userDTO.setRole(user.getRole());
        userDTO.setStatus(user.getStatus());
        userDTO.setRemainingLeaveDaysCounter(user.getRemainingLeaveDaysCounter());
        return userDTO;
    }
}