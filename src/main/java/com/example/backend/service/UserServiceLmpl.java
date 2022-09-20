package com.example.backend.service;

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.dto.UserUpdateDTO;
import com.example.backend.dto.UserViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceLmpl implements UserService {
private final UserRepository userRepository;
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {

        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user);
    }



    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {


        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional

    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final  User user=userRepository.save(new User(userCreateDTO.getUserName(),userCreateDTO.getFirstName(),userCreateDTO.getLastName()));

        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final  User user=userRepository.findById(id).orElseThrow(() ->new  NotFoundException("Not found"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());

        final User updatedUser=userRepository.save(user);

        return UserViewDTO.of(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        final  User user=userRepository.findById(id).orElseThrow(() ->new  NotFoundException(" User Not found"));
        userRepository.deleteById(user.getId());
    }

    @Override
    public List<UserViewDTO> slice(java.awt.print.Pageable pageable) {
        return null;
    }

    @Override
    @Transactional
    public List<UserViewDTO> slice(Pageable pageable) {

        return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
    }



}
