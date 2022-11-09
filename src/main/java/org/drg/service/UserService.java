package org.drg.service;

import org.drg.model.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserEntity> findAll ();

    void saveUser(UserEntity user);
}
