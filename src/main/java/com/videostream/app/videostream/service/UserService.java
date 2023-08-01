package com.videostream.app.videostream.service;
import com.videostream.app.videostream.dto.UserRequestDTO;
import com.videostream.app.videostream.entity.User;
import com.videostream.app.videostream.response.ResponseDTO;

public interface UserService {

    ResponseDTO saveUser(UserRequestDTO userRequestDTO);

    ResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);

    User getUserById(Long id);
}
