package com.videostream.app.videostream.serviceImpl;

import com.videostream.app.videostream.dto.UserRequestDTO;
import com.videostream.app.videostream.entity.User;
import com.videostream.app.videostream.controller.exception.InvalidInputFoundException;
import com.videostream.app.videostream.controller.exception.ResourceNotFoundException;
import com.videostream.app.videostream.controller.exception.UserAlreadyExitsException;
import com.videostream.app.videostream.repository.UserRepository;
import com.videostream.app.videostream.response.ResponseDTO;
import com.videostream.app.videostream.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public ResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        validateUser(userRequestDTO.getUsername());
        User user = new User();
        BeanUtils.copyProperties(userRequestDTO,user);
        userRepository.save(user);
        return new ResponseDTO(user.getId(), "User Updated Successfully");
    }

    private void validateUser(String username)  {
        Optional<User> exitsUser = userRepository.findByUsername(username);
        if(exitsUser.isPresent()) {

            throw new UserAlreadyExitsException("User Already exits with name " + username);
        }


    }

    @Override
    public ResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO) {

        User user = userRepository.findById(userId).orElseThrow(() -> new InvalidInputFoundException("User not found with id " + userId));
        BeanUtils.copyProperties(userRequestDTO,user,"password");
        userRepository.save(user);

        return new ResponseDTO(user.getId(), "User Updated Successfully");
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElseThrow(()->
        new ResourceNotFoundException(" User not found with id :" + id));
    }
}
